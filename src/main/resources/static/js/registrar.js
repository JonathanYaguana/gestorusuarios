$(document).ready(function() {

});

async function registrarUsuario(){
	
	let datos = {};
	datos.nombre=;
	
	const request = await fetch('api/usuarios', {
			method: 'GET',
			headers: {
				'Accept': 'application/json',
				'Content-Type': 'application/json'
			},
			body: JSON.stringify(datos)
		});
		const usuarios = await request.json();	
}