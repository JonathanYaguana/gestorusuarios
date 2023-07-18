$(document).ready(function() {
	cargarUsuarios();
	$('#usuarios').DataTable();

});

async function cargarUsuarios() {
		const request = await fetch('api/usuarios', {
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

			let botonHtml ='<a class="btn btn-outline-warning" onclick="eliminarUsuario(' + usuario.id + ')" href="#" role="button">Eliminar</a>';

			let usuarioHtml = 
			'<tr><td>' + usuario.id +
			'</td><td>' + usuario.nombre +
			'</td><td>' + usuario.apellido +
			'</td><td>' + usuario.email +
			'</td><td>' + usuario.telefono +
			'</td><td>' + botonHtml + '</td></tr>';
			
			listadoHtml += usuarioHtml;	
		}		
		
		document.querySelector('#usuarios tbody').outerHTML = listadoHtml;

}

async function eliminarUsuario(id){
	
	if(!confirm('¿Desea eliminar ese usario?')){
		return;
	}
	
	const request = await fetch('api/usuarios/' + id, {
			method: 'DELETE',
			headers: {
				'Accept': 'application/json',
				'Content-Type': 'application/json'
			}
		});
		
		location.reload()
}