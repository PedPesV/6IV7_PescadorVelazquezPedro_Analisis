#Calcularemos las distancias entre todos los pares de puntos y determinaremos cuáles están más alejados entre sí y cuáles están más cercanos, utilizando las distancias Euclidiana, Manhattan y Chebyshev.
#Ejercicio: Determinación de Distancias entre Puntos
#Puntos en el Plano

#Los puntos en el plano son los siguientes:

#    Punto A: (2, 3)
#   Punto B: (5, 4)
#    Punto C: (1, 1)
#    Punto D: (6, 7)
#    Punto E: (3, 5)
#    Punto F: (8, 2)
#    Punto G: (4, 6)
#    Punto H: (2, 1)

import numpy as np
import pandas as pd
from scipy.spatial import distance 

tiendas = {
    'Punto A': (2, 3),
    'Punto B': (5, 4),
    'Punto C': (1, 1),
    'Punto D': (6, 7),
    'Punto E': (3, 5),
    'Punto F': (8, 2),
    'Punto G': (4, 6),
    'Punto H': (2, 1)
}

df_tiendas = pd.DataFrame(tiendas).T
df_tiendas.columns = ['X', 'Y']
print('Coordenadas de las tiendas:')
print(df_tiendas)

distancias_punto1 = pd.DataFrame(index=df_tiendas.index, columns=df_tiendas.index)
distancias_punto2 = pd.DataFrame(index=df_tiendas.index, columns=df_tiendas.index)
distancias_punto3 = pd.DataFrame(index=df_tiendas.index, columns=df_tiendas.index)

for i in df_tiendas.index:
    for j in df_tiendas.index:
        distancias_punto1.loc[i, j] = distance.euclidean(df_tiendas.loc[i], df_tiendas.loc[j])
        distancias_punto2.loc[i, j] = distance.cityblock(df_tiendas.loc[i], df_tiendas.loc[j])
        distancias_punto3.loc[i, j] = distance.chebyshev(df_tiendas.loc[i], df_tiendas.loc[j])

print('\nDistancia euclidiana entre cada una de las tiendas')
print(distancias_punto1)
print('\nDistancia cityblock entre cada una de las tiendas')
print(distancias_punto2)
print('\nDistancia Chebyshev entre cada una de las tiendas')
print(distancias_punto3)

def encontrar_extremos(df_distancias, nombre):
    print(f'\n--- {nombre.upper()} ---')
    distancias = df_distancias.copy().astype(float)
    np.fill_diagonal(distancias.values, np.nan)
    min_valor = distancias.min().min()
    min_puntos = distancias.stack()[distancias.stack() == min_valor].index[0]
    print(f'Mínima distancia: {min_valor:.2f} entre {min_puntos[0]} y {min_puntos[1]}')
    max_valor = distancias.max().max()
    max_puntos = distancias.stack()[distancias.stack() == max_valor].index[0]
    print(f'Máxima distancia: {max_valor:.2f} entre {max_puntos[0]} y {max_puntos[1]}')

encontrar_extremos(distancias_punto1, 'Distancia Euclidiana')
encontrar_extremos(distancias_punto2, 'Distancia Manhattan')
encontrar_extremos(distancias_punto3, 'Distancia Chebyshev')
