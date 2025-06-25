window.onload = function () {
    const pagina = window.location.pathname;

    if (pagina.includes("aes_cif")) {
        iniciarCifrado();
    } else if (pagina.includes("aes_des")) {
        iniciarDescifrado();
    }
};

// Función para CIFRADO
function iniciarCifrado() {
    const botonCifrar = document.querySelector(".button");
    const botonDescargar = document.getElementById("descargar");

    botonCifrar.addEventListener("click", function () {
        const mensaje = document.getElementById("texto").value;
        const clave = document.getElementById("pass").value;

        if (mensaje.trim() === "" || clave.trim() === "") {
            alert("Por favor escribe un mensaje y una clave.");
            return;
        }

        const cifrado = CryptoJS.AES.encrypt(mensaje, clave).toString();
        document.getElementById("resultado").value = cifrado;
        localStorage.setItem("textoCifrado", cifrado);
    });

    botonDescargar.addEventListener("click", function () {
        const contenido = localStorage.getItem("textoCifrado");

        if (!contenido) {
            alert("Primero cifra un mensaje antes de descargar.");
            return;
        }

        const blob = new Blob([contenido], { type: "text/plain;charset=utf-8" });
        const enlace = document.createElement("a");
        enlace.href = URL.createObjectURL(blob);
        enlace.download = "mensaje_cifrado.txt";
        enlace.click();
    });
}

// Función para DESCIFRADO
function iniciarDescifrado() {
    const inputArchivo = document.getElementById("file");
    const botonDescifrar = document.querySelector('input[type="submit"]');
    const inputClave = document.getElementById("pass");
    const textareaResultado = document.getElementById("texto_des");

    let contenidoArchivo = "";

    inputArchivo.addEventListener("change", function () {
        const archivo = this.files[0];
        if (archivo) {
            const lector = new FileReader();
            lector.onload = function (e) {
                contenidoArchivo = e.target.result;
            };
            lector.readAsText(archivo);
        }
    });

    botonDescifrar.addEventListener("click", function () {
        const clave = inputClave.value;

        if (!contenidoArchivo) {
            alert("Por favor carga un archivo primero.");
            return;
        }

        if (clave.trim() === "") {
            alert("Por favor escribe una clave.");
            return;
        }

        try {
            const descifrado = CryptoJS.AES.decrypt(contenidoArchivo, clave);
            const textoPlano = descifrado.toString(CryptoJS.enc.Utf8);

            if (!textoPlano) {
                throw new Error("Clave incorrecta o contenido inválido.");
            }

            textareaResultado.value = textoPlano;
        } catch (error) {
            alert("No se pudo descifrar. Verifica la clave o el archivo.");
        }
    });
}
