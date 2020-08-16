/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function(ev){

    /*Função que valida se a senha é toda em branco ou possui apenas espaços*/
    function validaSenha(senha){
        return (/^\s*$/.test(senha));
    }

    /*Funcão que verifica se as senhas estão de acordo e ativa/desativa o botão*/
    function verificaSenha() {
        let meuSpan = document.querySelector("#error");
        let senha1 = $(".nova_senha").val();
        let senha2 = $(".confirma_senha").val();   

        /*Verifica se as senhas são iguais*/
        if (senha1 !== senha2){        
            meuSpan.innerText = ("As senhas precisam ser iguais.");
            meuSpan.style.color = "red";
            document.getElementById("botao").disabled = true;
        }
        /*Verifica se as senhas são em branco ou somente espaços*/
        else if (validaSenha(senha1)){
            meuSpan.innerText = ("As senhas não podem ser em branco ou ter somente espaços.");
            meuSpan.style.color = "red";
            document.getElementById("botao").disabled = true;
        }
        else {
            meuSpan.innerText = ("");
            document.getElementById("botao").disabled = false;
        }
    }
    
    $("#valida").keyup(verificaSenha);
    $("#valida2").keyup(verificaSenha);
});


