$(document).ready(function() {

});

async function registrarUsuario(){
	
let datos = {};
	datos.nombre = document.getElementById('txtNombre').value;
	datos.apellido = document.getElementById('txtApellido').value;
	datos.email = document.getElementById('txtCorreo').value;
	datos.telefono = document.getElementById('txtTelefono').value;
	datos.password = document.getElementById('txtPassword').value;
	
	let repetirPassword = document.getElementById('txtrepetirPassword').value;
	
	if(repetirPassword != datos.password){
		alert('La contraseña que escribiste no coicide');
		return;
	}
	
	const request = await fetch('api/usuarios', {
			method: 'POST',
			headers: {
				'Accept': 'application/json',
				'Content-Type': 'application/json'
			},
			body: JSON.stringify(datos)
		});
	location.reload()
}