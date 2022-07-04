const form_crearPaciente = '<form> <div class="mb-3"> <label for="crearPaciente_nombre" class="form-label">Nombre</label> <input type="text" class="form-control" id="crearPaciente_nombre" placeholder="Nombre"> </div> <div class="mb-3"> <label for="crearPaciente_apellido" class="form-label">Apellido</label> <input type="text" class="form-control" id="crearPaciente_apellido" placeholder="Apellido"> </div> <div class="mb-3"> <label for="crearPaciente_DNI" class="form-label">DNI</label> <input type="text" class="form-control" id="crearPaciente_DNI" placeholder="11222333"> </div> <input type="submit" value="crear paciente"> </form>'
const verPacientes = `<table class="table table-striped table-hover">
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