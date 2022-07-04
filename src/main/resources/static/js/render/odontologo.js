const form_crearOdontologo = '<form>  <div class="mb-3">     <label for="crearOdontologo_nombre" class="form-label">Nombre</label>     <input type="text" class="form-control" id="crearOdontologo_nombre" placeholder="Nombre">   </div>   <div class="mb-3">     <label for="crearOdontologo_apellido" class="form-label">Apellido</label>     <input type="text" class="form-control" id="crearOdontologo_apellido" placeholder="Apellido">   </div>   <div class="mb-3">     <label for="crearOdontologo_matricula" class="form-label">Matrícula</label>     <input type="text" class="form-control" id="crearOdontologo_matricula" placeholder="MN 3245">   </div>   <input type="submit" value="Crear Odontólogo" class="btn-success"> </form> '

// Array con los objetos de prueba
let listaOdontologos = [
{
id: 1,
nombre: "Fabricio",
apellido: "Montivero",
matricula: "123"
},
{
id: 2,
nombre: "Micaela",
apellido: "Barbero",
matricula: "456"
},
{
id: 3,
nombre: "Lali",
apellido: "Espósito",
matricula: "798"
},
{
id: 4,
nombre: "Tini",
apellido: "Stoessel",
matricula: "147"
}
]

// Cargando una Fila
let cargarFilaOdontologo = "";
for (let odontologo of listaOdontologos){
cargarFilaOdontologo += `<tr>
                                <th scope="row">${odontologo.id}</th>
                                <td>${odontologo.nombre}</td>
                                <td>${odontologo.apellido}</td>
                                <td>${odontologo.matricula}</td>
                          </tr>`
}

// Lista de Odontologos en la tabla
let verOdontologos = `<table class="table table-hover">
                                      <thead>
                                      <tr>
                                        <th scope="col">Id</th>
                                        <th scope="col">Nombre</th>
                                        <th scope="col">Apellido</th>
                                        <th scope="col">Matrícula</th>
                                        <th scope="col">Acción</th>
                                      </tr>
                                      </thead>
                                      <tbody>
                                      ${cargarFilaOdontologo}
                                      </tbody>
                                    </table>`

