// Evento cuando Carga: aparece este cartelito
window.addEventListener('load', () => {
    title.textContent = "¡Hola!"
    accion.textContent = ""
    contenido.innerHTML = "Seleccioná una opción del menú desplegable"
})

// Representa a la opción que se seleccionó.
// Función de renderizar el titulo correcto, la acción correcta y el botón
function renderizarOpcion(opcion) {
    title.textContent = opcion.titulo
    accion.textContent = opcion.accion.textContent
    contenido.innerHTML = opcion.contenido
}


function habilitarBoton(titulo){
    let formulario = document.forms[0]; // Agarro el formulario
    formulario.addEventListener("submit", (e) => {
    e.preventDefault();
    switch(titulo){
    case "Odontólogo":
        let o = {
        nombre: document.querySelector("#crearOdontologo_nombre").value,
        apellido: document.querySelector("#crearOdontologo_apellido").value,
        matricula: document.querySelector("#crearOdontologo_matricula").value,
        }
        crearOdontologo(o);
        alert("¡Creaste un Odontólogo!")
        document.querySelector("#crearOdontologo_nombre").value = "";
        document.querySelector("#crearOdontologo_apellido").value = "";
        matricula: document.querySelector("#crearOdontologo_matricula").value = "";
        break;
    case "Paciente":
        let p = {nombre: document.querySelector("#crearPaciente_nombre").value,
        apellido: document.querySelector("#crearPaciente_apellido").value,
        dni: document.querySelector("#crearPaciente_DNI").value
        }
        crearPaciente(p);
        alert("¡Creaste un Paciente!");
        document.querySelector("#crearPaciente_nombre").value = "";
        document.querySelector("#crearPaciente_apellido").value = "";
        document.querySelector("#crearPaciente_DNI").value = "";
        break;
    case "Turno":
        "Método Crear Turnos"
        break;
    }
    })
//        for (let datos of formulario){ // Recorre los datos del formulario
//            console.log(datos.value)
//            }
//        })
}

// Recorro el Menú, por cada item de este menu, le agrego al botón el evento que corresponde a cada botón.
// Cuando le hagan click al botón, va a RENDERIZAR lo que se necesita (llama a la funcion de arriba)
for (let item of Menu) {
    item.accion.addEventListener('click', ()=>{
        renderizarOpcion(item) // Renderizo los items (llama a la funcion de arriba)
        habilitarBoton(item.titulo);
    })
}

// Después de renderizar el menú y sus opciones, busque el elemento form.
