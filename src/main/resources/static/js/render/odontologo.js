const form_crearOdontologo = '<form>  <div class="mb-3">     <label for="crearOdontologo_nombre" class="form-label">Nombre</label>     <input type="text" class="form-control" id="crearOdontologo_nombre" placeholder="Nombre">   </div>   <div class="mb-3">     <label for="crearOdontologo_apellido" class="form-label">Apellido</label>     <input type="text" class="form-control" id="crearOdontologo_apellido" placeholder="Apellido">   </div>   <div class="mb-3">     <label for="crearOdontologo_matricula" class="form-label">Matricula</label>     <input type="text" class="form-control" id="crearOdontologo_matricula" placeholder="MN 3245">   </div>   <input type="submit" value="crear odontologo"> </form> '
let verOdontologos = `<table class="table table-striped table-hover">
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