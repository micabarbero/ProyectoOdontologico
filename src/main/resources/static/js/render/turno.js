let listaPacientesPorDNI = '<option selected>Selecciona un paciente</option><option value="1">One</option><option value="2">Two</option><option value="3">Three</option>'
let listaOdontologosPorApellido = '<option selected>Selecciona un paciente</option><option value="1">One</option><option value="2">Two</option><option value="3">Three</option>'
let form_crearTurno = `<form><div class="row"><div class="col"><div class="form-floating"><input type="text" class="form-control" id="crearTurno_buscarPacientePorDNI" placeholder="11222333"><label for="crearTurno_buscarPacientePorDNI">Buscar paciente por DNI</label></div><select class="form-select" size="5">${listaPacientesPorDNI}</select></div><div class="col"><div class="form-floating"><input type="text" class="form-control" id="crearTurno_buscarOdontologoPorApellido" placeholder="Apellido"><label for="crearTurno_buscarOdontologoPorApellido">Buscar odontologo por apellido</label></div><select class="form-select" size="5">${listaOdontologosPorApellido}</select></div></div><div class="form-floating my-3"><input type="datetime-local" class="form-control" id="crearTurno_seleccionarFecha" placeholder="Apellido"><label for="crearTurno_seleccionarFecha">Seleccionar fecha y hora para el turno</label></div><input type="submit" value="crear Turno"></form>`
let verTurnos = `<table class="table table-striped table-hover">
                                 <thead>
                                 <tr>
                                   <th scope="col">#</th>
                                   <th scope="col">First</th>
                                   <th scope="col">Last</th>
                                   <th scope="col">Handle</th>
                                 </tr>
                                 </thead>
                                 <tbody>
                                 <tr>
                                   <th scope="row">1</th>
                                   <td>Mark</td>
                                   <td>Otto</td>
                                   <td>@mdo</td>
                                 </tr>
                                 <tr>
                                   <th scope="row">2</th>
                                   <td>Jacob</td>
                                   <td>Thornton</td>
                                   <td>@fat</td>
                                 </tr>
                                 <tr>
                                   <th scope="row">3</th>
                                   <td colspan="2">Larry the Bird</td>
                                   <td>@twitter</td>
                                 </tr>
                                 </tbody>
                               </table>`