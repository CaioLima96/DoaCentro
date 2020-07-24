<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%
  if (session.getAttribute("user") == null)
  {
    String address =  "login.jsp";
    response.sendRedirect(address);
  }
    
%>

<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="Conectando a bondade" />
        <meta name="author" content="Grupo KWR" />
        <title>DoaCentro</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/img/favicon-16x16.png" />
        <!-- Font Awesome icons (free version)-->
        <script src="https://use.fontawesome.com/releases/v5.13.0/js/all.js" crossorigin="anonymous"></script>
        <!-- Google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
        <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet"/>


        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script>
            $(document).ready(function() {
                $("#cadastrar").click(function() {
                    event.preventDefault();

                    var nome_digitado = $("#nomeUsuario").val();
                    var telefone1_digitado = $("#telefone1").val();
                    var cep_digitado = $("#cep").val();
                    var logradouro_digitado = $("#logradouro").val();
                    var numeroEndereco_digitado = $("#numeroEndereco").val();
                    var complemento_digitado = $("#complemento").val();
                    var bairro_digitado = $("#bairro").val();
                    var cidade_digitado = $("#cidade").val();
                    var estado_digitado = $("#estado").val();
                    var _alimento = $("#alimento").val();
                    var _higiene = $("#higiene").val();
                    var _limpeza = $("#limpeza").val();
                    var _descricao = $("#descricao").val();
                    

                    $.ajax(
                        {
                            url: "listarCentro?"+ 
                            "nomeUsuario="+nome_digitado+
                            "&telefone1="+telefone1_digitado+
                            "&cep="+cep_digitado+
                            "&tipoLogradouro="+tipoLogradouro_digitado+
                            "&logradouro="+logradouro_digitado+
                            "&numeroEndereco="+numeroEndereco_digitado+
                            "&complemento="+complemento_digitado+
                            "&bairro="+bairro_digitado+
                            "&cidade="+cidade_digitado+
                            "&estado="+estado_digitado+
                            "&alimento="+_alimento+
                            "&higiene="+_higiene+
                            "&limpeza="+_limpeza+
                            "&descricao="+_descricao,
                            contentType: "charset=UTF-8",
                            success: function(retorno) {
                                if (retorno.trim()=="ok") {
                                    location.replace("mensagem_cadastrar.jsp");  //sucesso
                                    } 
                                    else {
                                        //erro
                                        $ ("#mostrarErro").html (retorno);
                                        $('#myModal').modal('show'); 
                                    
                                }
                            }
                        }
                    );
                });
               
            });
        </script>



    </head>
    <body id="page-top">
        <!-- Navigation-->
        <nav class="navbar navbar-expand-lg bg-secondary text-uppercase fixed-top" id="mainNav">
            <div class="container">
                <a class="navbar-brand js-scroll-trigger" href="index.jsp">DoaCentro</a><button class="navbar-toggler navbar-toggler-right text-uppercase font-weight-bold bg-primary text-white rounded" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">Menu <i class="fas fa-bars"></i></button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="cadastro-centro.jsp">Cadastrar Centro</a></li>
                        <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="entrar.jsp">Sair</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <!-- Masthead-->
        <header class="masthead bg-primary text-white text-center">
           
        </header>
        <section class="page-section bg-primary text-white mb-0" id="sobre">
        
            <div class="container d-flex align-items-center flex-column">
                <!-- Masthead Avatar Image--><img class="mx-auto rounded-circle" src="assets/img/cake.png" style="width: 200px; height: 200px;" alt="" /><!-- Masthead Heading-->
               
                <div class="divider-custom divider-light">
                    <div class="divider-custom-line"></div>
                    <div class="divider-custom-icon"><i class="fas fa-star"></i></div>
                    <div class="divider-custom-line"></div>
                </div>
                
                
            </div>
            <div class="container d-flex align-items-center flex-column">
            <form action="#" method="#">
                
                <h5 class="font-weight-light my-4">Dados do Centro de Distribuição</h5>
                <div class="form-row">
                    
                    
                    <div class="col-md-12">
                        <div class="form-group">
                            <label class="small mb-1" for="nomeUsuario">Nome</label>
                            <input class="form-control py-3" id="nomeUsuario" name="nomeUsuario" type="text" placeholder="Digite seu nome" value=""/>
                        </div>
                    </div>
                    

                </div>
            
                <div class="form-row">    
                    
                    <div class="col-md-6">
                        <div class="form-group">
                            <label class="small mb-1.1" for="telefone1">Telefone</label>
                            <input class="telefone1 form-control py-3" id="telefone1" name="telefone1" type="text" placeholder="Telefone" value=""/>
                        </div>
                    </div>
                    

                     <div class="col-md-3">    </div>
                </div>

               
                <div class="form-row">
                    
                    <div class="col-md-6">
                        <div class="form-group">
                            <label class="small mb-1" for="cep">CEP<i class="fas fa-search" style="margin-left: 10px;"  onclick="pesquisacep(cep.value);"></i></label>
                            <input class="form-control py-3" id="cep" name="cep" type="text" onblur="pesquisacep(this.value);" value="" placeholder="Digite o CEP"/>
                        </div>
                    </div>

                   

                    <div class="col-md-6">
                        <div class="form-group">
                            <label class="small mb-1" for="logradouro">Logradouro</label>
                            <input class="form-control py-3" id="logradouro" name="logradouro" type="text" placeholder="Nome logradouro" value=""/>
                        </div>
                    </div>
                                
                </div>

                <div class="form-row">
            
                    <div class="col-md-3">
                        <div class="form-group">
                            <label class="small mb-1" for="numeroEndereco">Número</label>
                            <input class="form-control py-3" id="numeroEndereco" name="numeroEndereco" type="text" placeholder="Nº do local" value=""/>
                        </div>
                    </div>
                    <div class="col-md-9">
                        <div class="form-group">
                            <label class="small mb-1" for="complemento">Complemento</label>
                            <input class="form-control py-3" id="complemento" name="complemento" type="text" placeholder="Complemento" value=""/>
                        </div>
                    </div>
                </div>
                
                   
                <div class="form-row">
                    <div class="col-md-4">
                        <div class="form-group">
                            <label class="small mb-1" for="bairro">Bairro</label>
                            <input class="form-control py-3" id="bairro" name="bairro" type="text" placeholder="Bairro" value=""/>
                        </div>
                    </div>

                     
                 
                   
                    <div class="col-md-4">
                        <div class="form-group">
                            <label class="small mb-1" for="cidade" >Cidade</label>
                            <input class="form-control py-3" id="cidade" name="cidade" type="text" placeholder="Cidade" onkeypress="return apenasLetras(event);" value=""/>
                        </div>
                    </div>
                

                    <div class="col-md-4">
                        <label class="small mb-1" for="estado">Estado</label>
                        <select id="estado" name="estado" class="form-control">
                            <option value="">Selecione o estado</option>
                            <option value="1">Acre</option>
                            <option value="2">Alagoas</option>
                            <option value="3">Amapá</option>
                            <option value="4">Amazonas</option>
                            <option value="5">Bahia</option>
                            <option value="6">Ceará</option>
                            <option value="7">Distrito Federal</option>
                            <option value="8">Espírito Santo</option>
                            <option value="9">Goiás</option>
                            <option value="10">Maranhão</option>
                            <option value="11">Mato Grosso</option>
                            <option value="12">Mato Grosso do Sul</option>
                            <option value="13">Minas Gerais</option>
                            <option value="14">Pará</option>
                            <option value="15">Paraíba</option>
                            <option value="16">Paraná</option>
                            <option value="17">Pernambuco</option>
                            <option value="18">Piauí</option>
                            <option value="19">Rio de Janeiro</option>
                            <option value="20">Rio Grande do Norte</option>
                            <option value="21">Rio Grande do Sul</option>
                            <option value="22">Rondônia</option>
                            <option value="23">Roraima</option>
                            <option value="24">Santa Catarina</option>
                            <option value="25">São Paulo</option>
                            <option value="26">Sergipe</option>
                            <option value="27">Tocantins</option>

                        </select>
                    </div>

                    

                    

                </div>
                   
                <div class="form-row">

                    <h5 class="font-weight-light my-4">Tipos de Itens (marque os itens que está aceitando):</h5>
                </div>

                <div class="form-row">
                    <br>
                    <div class="custom-control custom-checkbox">
                        <input type="checkbox" class="custom-control-input" value="alimento" id="alimento">
                        <label class="custom-control-label" for="alimento">Alimentos não perecíveis</label>
                      </div>
                </div>

                
                <div class="form-row">
                    <br>
                    <div class="custom-control custom-checkbox">
                        <input type="checkbox" class="custom-control-input" value="higiene" id="higiene">
                        <label class="custom-control-label" for="higiene">Higiene Pessoal</label>
                      </div>
                </div>

                
                <div class="form-row">
                    <br>
                    <div class="custom-control custom-checkbox">
                        <input type="checkbox" class="custom-control-input" value="limpeza" id="limpeza">
                        <label class="custom-control-label" for="limpeza">Limpeza</label>
                      </div>
                </div>
                <div class="form-row">
                    <h5 class="font-weight-light my-4">Descrição do Centro de Districuição:</h5>
                    <textarea class="form-control" id="descricao" name="descricao" rows="3"></textarea>
                </div>
            
                   
               

               
                <div class="form-row">
                    
                <div class="text-center mt-4">
                    <button class="btn btn-xl btn-outline-light" style=" margin-right: 20px;" id="alterar">Alterar Centro</button>
                </div>
                <div class="text-center mt-4">
                    <button class="btn btn-xl btn-outline-light" style=" margin-right: 20px;" id="desabilitar">Desabilitar Centro</button>
                </div>
                <div class="text-center mt-4">
                    <button class="btn btn-xl btn-outline-light" id="excluir">Excluir Centro</button>
                </div>
                                                  
                   </div>
                <div id="myModal" class="modal fade" tabindex="-1" role="dialog">
                    <div class="modal-dialog" role="document">
                      <div class="modal-content">
                        <div class="modal-header">
                          <h5 class="modal-title">Atenção!</h5>
                          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                          </button>
                        </div>
                          <div class="modal-body py-5">    
                            <h6 class="text-danger text-center"> 
                                <div class="" id="mostrarErro"></div>
                            </h6>
                          </div>
                        <div class="modal-footer">
                          <button type="button" class="btn btn-dark" data-dismiss="modal">Fechar</button>
                        </div>
                      </div>
                    </div>
                  </div> 
            
            </form>
            </div>
        </section>
        <!-- Sobre Section-->
        
        <!-- Contact Section-->
       
          <!-- Footer-->
        <footer class="footer text-center">
            <div class="container">
                <div class="row">
                    
                    
                    <!-- Footer Social Icons-->
                    <div class="col-lg-12 mb-5 mb-lg-0">
                        <h4 class="text-uppercase mb-4">Redes Sociais</h4>
                        <a class="btn btn-outline-light btn-social mx-1" href="#!"><i class="fab fa-fw fa-facebook-f"></i></a><a class="btn btn-outline-light btn-social mx-1" href="#!"><i class="fab fa-fw fa-twitter"></i></a><a class="btn btn-outline-light btn-social mx-1" href="#!"><i class="fab fa-fw fa-linkedin-in"></i></a><a class="btn btn-outline-light btn-social mx-1" href="#!"><i class="fab fa-fw fa-dribbble"></i></a>
                    </div>
                    
                </div>
            </div>
        </footer>
        <!-- Copyright Section-->
        <div class="copyright py-4 text-center text-white">
            <div class="container"><small>Copyright © Your Website 2020</small></div>
        </div>
        <!-- Scroll to Top Button (Only visible on small and extra-small screen sizes)-->
        <div class="scroll-to-top d-lg-none position-fixed">
            <a class="js-scroll-trigger d-block text-center text-white rounded" href="#page-top"><i class="fa fa-chevron-up"></i></a>
        </div>
        
        <!-- Bootstrap core JS-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.bundle.min.js"></script>
        <!-- Third party plugin JS-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>
        <!-- Contact form JS-->
        <script src="assets/mail/jqBootstrapValidation.js"></script>
        <script src="assets/mail/contact_me.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
    </body>
</html>
