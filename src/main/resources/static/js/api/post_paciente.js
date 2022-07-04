// Fetch a mi API. En vez de pasarlo por postman, se lo paso bien.
// Esto

const uriPaciente = "/pacientes";
function crearPaciente(paciente) {
    return fetch(uriPaciente,
        {method:'POST',
        headers: {'Content-Type':'application/json'},
        body: JSON.stringify(paciente)})
    .then(response => response.json())
    .then(data => {
        console.log(data)
        return data
        })
}
