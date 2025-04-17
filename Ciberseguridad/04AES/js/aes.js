var mensaje = "habia una vez un patito que decia miau miau"
var pass = "qwertyui"
var cifrado = CryptoJS.AES.encrypt(mensaje, pass)
var descifrado = CryptoJS.AES.decrypt(cifrado, pass)

//para que se vea
document.getElementById("demo00").innerHTML = mensaje
document.getElementById("demo01").innerHTML = cifrado
document.getElementById("demo02").innerHTML = descifrado
document.getElementById("demo03").innerHTML = descifrado.toString(CryptoJS.enc.Utf8); 
