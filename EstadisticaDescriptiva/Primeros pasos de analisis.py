import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import sys

# 1. Leer los archivos CSV
try:
    df = pd.read_csv('./EstadisticaDescriptiva/libros/proyecto1.csv')
    dg = pd.read_csv('./EstadisticaDescriptiva/libros/Catalogo_sucursal.csv')
except Exception as e:
    print("Error al leer los archivos:", e)
    sys.exit()

# Crear un diccionario de mapeo de id_sucursal a nombre de sucursal
mapa_sucursales = dict(zip(dg['id_sucursal'], dg['suc']))

# Reemplazar los valores de id_sucursal por sus nombres en df
df['id_sucursal'] = df['id_sucursal'].map(mapa_sucursales)

# Guardar el archivo modificado
df.to_csv('./EstadisticaDescriptiva/libros/proyecto1_modificado.csv', index=False)

# Mostrar las primeras filas para verificar cambios
print(df.head())

# Convertir la columna B_mes a datetime si existe
df['B_mes'] = pd.to_datetime(df['B_mes'], dayfirst=True, errors='coerce')

# 1) Ventas totales del comercio
ventas_totales = df['ventas_tot'].sum()
print("Ventas totales del comercio:", ventas_totales)

# 2) Número de socios con adeudo y sin adeudo
df_con_adeudo = df[df['B_adeudo'].str.strip().str.lower() == "con adeudo"]
df_sin_adeudo = df[df['B_adeudo'].str.strip().str.lower() == "sin adeudo"]

socios_con_deuda = df_con_adeudo['no_clientes'].sum()
socios_sin_deuda = df_sin_adeudo['no_clientes'].sum()
total_socios = df['no_clientes'].sum()

porcentaje_con_deuda = (socios_con_deuda / total_socios) * 100 if total_socios else 0
porcentaje_sin_deuda = (socios_sin_deuda / total_socios) * 100 if total_socios else 0

print(f"Socios con deuda: {socios_con_deuda} ({porcentaje_con_deuda:.2f}%)")
print(f"Socios sin deuda: {socios_sin_deuda} ({porcentaje_sin_deuda:.2f}%)")

# 3) Gráfica de ventas totales respecto del tiempo
ventas_por_bmes = df.groupby(df['B_mes'].dt.date)['ventas_tot'].sum()
plt.figure(figsize=(10, 6))
ventas_por_bmes.plot(kind='bar', color='skyblue')
plt.title("Ventas Totales Respecto del Tiempo")
plt.xlabel("Fecha")
plt.ylabel("Ventas Totales")
plt.xticks(rotation=45)
plt.tight_layout()
plt.show()

# 4) Gráfica de desviación estándar de los pagos respecto del tiempo
std_pagos_por_bmes = df.groupby(df['B_mes'].dt.date)['pagos_tot'].std()
plt.figure(figsize=(10, 6))
std_pagos_por_bmes.plot(kind='bar', color='salmon')
plt.title("Desviación Estándar de los Pagos Totales por Tiempo")
plt.xlabel("Fecha")
plt.ylabel("Desviación Estándar")
plt.xticks(rotation=45)
plt.tight_layout()
plt.show()

# 5) Deuda total de los clientes
deuda_total = df['adeudo_actual'].sum()
print("Deuda total de los clientes:", deuda_total)

# 6) Porcentaje de utilidad del comercio
porcentaje_utilidad = ((ventas_totales - deuda_total) / ventas_totales) * 100 if ventas_totales != 0 else 0
print(f"Porcentaje de utilidad del comercio: {porcentaje_utilidad:.2f}%")

# 7) Gráfico circular de ventas por sucursal
ventas_por_sucursal = df.groupby('id_sucursal')['ventas_tot'].sum()
plt.figure(figsize=(8, 8))
ventas_por_sucursal.plot(kind='pie', autopct='%1.1f%%', startangle=90)
plt.title("Ventas por Sucursal")
plt.ylabel("")
plt.tight_layout()
plt.show()

# 8) Gráfico de deuda total vs. margen de utilidad por sucursal
datos_sucursal = df.groupby('id_sucursal').agg({
    'adeudo_actual': 'sum',
    'ventas_tot': 'sum'
}).reset_index()

datos_sucursal['margen_utilidad'] = datos_sucursal.apply(lambda row: (row['ventas_tot'] - row['adeudo_actual']) / row['ventas_tot'] * 100 if row['ventas_tot'] != 0 else 0, axis=1)

plt.figure(figsize=(10, 6))
plt.scatter(datos_sucursal['adeudo_actual'], datos_sucursal['margen_utilidad'], s=100, alpha=0.7)

for i, sucursal in enumerate(datos_sucursal['id_sucursal']):
    plt.annotate(sucursal, (datos_sucursal['adeudo_actual'].iloc[i], datos_sucursal['margen_utilidad'].iloc[i]), textcoords="offset points", xytext=(5, 5), ha='center')

plt.title("Deuda Total vs. Margen de Utilidad por Sucursal")
plt.xlabel("Deuda Total")
plt.ylabel("Margen de Utilidad (%)")
plt.grid(True)
plt.tight_layout()
plt.show()
