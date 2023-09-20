$(document).ready(function() {
	cargarUsuarios();
	$('#usuarios').DataTable();

});

async function cargarUsuarios() {
		const request = await fetch('api/usuarios', {
			method: 'GET',
			headers: getHeaders()
		});
		const usuarios = await request.json();

		console.log(usuarios);
		
		let listadoHtml = '';
		
		for(let usuario of usuarios){

			let botonHtml ='<a class="btn btn-outline-warning" onclick="eliminarUsuario(' + usuario.id + ')" href="#" role="button">Eliminar</a>';
			let txtTelefono =  usuario.telefono == null ? '-': usuario.telefono;
			let usuarioHtml = 
			'<tr><td>' + usuario.id +
			'</td><td>' + usuario.nombre +
			'</td><td>' + usuario.apellido +
			'</td><td>' + usuario.email +
			'</td><td>' + txtTelefono +
			'</td><td>' + botonHtml + '</td></tr>';
			
			listadoHtml += usuarioHtml;	
		}		
		
		document.querySelector('#usuarios tbody').outerHTML = listadoHtml;

}

function getHeaders(){
	return {
				'Accept': 'application/json',
				'Content-Type': 'application/json',
				'Authorization': localStorage.token
			}
}

async function eliminarUsuario(id){
	
	if(!confirm('¿Desea eliminar ese usario?')){
		return;
	}
	
	const request = await fetch('api/usuarios/' + id, {
			method: 'DELETE',
			headers: getHeaders()
		});
		
		location.reload()
}