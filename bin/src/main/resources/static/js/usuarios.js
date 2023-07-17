$(document).ready(function() {
	cargarUsuarios();
	$('#usuarios').DataTable();

});

async function cargarUsuarios() {
		const request = await fetch('usuarios', {
			method: 'GET',
			headers: {
				'Accept': 'application/json',
				'Content-Type': 'application/json'
			}
		});
		const usuarios = await request.json();

		console.log(usuarios);
		
		let listadoHtml = '';
		
		for(let usuario of usuarios){
			let usuarioHtml = 
			'<tr><td>'+usuario.id+
			'</td><td>'+usuario.nombre+
			'</td><td>'+usuario.apellido+
			'</td><td>'+usuario.email+
			'</td><td>'+usuario.telefono
			+'</td><td><a class="btn btn-outline-warning" href="#" role="button">Eliminar</a></td></tr>';
			
			listadoHtml += usuarioHtml;	
		}		
		
		document.querySelector('#usuarios tbody').outerHTML = listadoHtml;
}