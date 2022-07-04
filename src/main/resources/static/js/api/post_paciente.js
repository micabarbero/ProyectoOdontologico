function crearPaciente(paciente) {
    return fetch("v1/paciente", {method:'POST', headers: {'Content-Type':'application/json'}, body: JSON.stringify(paciente)})
    .then(response => response.json())
    .then(data => {
        console.log(data)
        return data
        })
}

const p = {nombre:'Paciente', apellido:"apellido",dni:"123"}
crearPaciente(p)