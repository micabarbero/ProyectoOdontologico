const uriOdonto = "/odontologos";
function crearOdontologo(odontologo) {
    return fetch(uriOdonto,
        {method:'POST',
        headers: {'Content-Type':'application/json'},
        body: JSON.stringify(odontologo)})
    .then(response => response.json())
    .then(data => {
        console.log(data)
        return data
        })
}