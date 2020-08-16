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
    return '';
    }
    
    /*Retira a máscara*/
    function tiraMascara(telefone){
        var tel = telefone.replace(/[^0-9]+/g,'');
        return (tel);
    }
    
    /*Criação da máscara para formatar o telefone*/
    (function($) {
        $.fn.maskbrphone = function(options) {
            var defaults = {
                useDdd            : false,
                useDddParenthesis : true,
                dddSeparator      : ' ',
                numberSeparator   : '-'
            };
            var settings = $.extend({}, defaults, options);
            var plugin = this;

            var initialize = function() {
                return plugin.each( function() {
                    $(this).val(applyMask($(this).val()));

                    $(this).keyup(function() {
                        $(this).val(applyMask($(this).val()));
                    });
                });
            };

            var applyMask = function(input) {
                if ( ! input.length) {
                    return '';
                }
                var fone = input.replace(/\D/g, ''); // Remove tudo o que não for dígito
                var ddd = '',
                    prefix,
                    suffix;

                if ( ! settings.useDdd && input.charAt(0) === '9') {
                    prefix = fone.substring(0, 5);
                    suffix = fone.substring(5, 9);
                } else if (settings.useDdd && input.charAt(5) === '9') {
                    ddd = fone.substring(0, 2);
                    prefix = fone.substring(2, 7);
                    suffix = fone.substring(7, 11);
                } else if ( ! settings.useDdd && input.charAt(0) !== '9') {
                    prefix = fone.substring(0, 4);
                    suffix = fone.substring(4, 8);
                } else if (settings.useDdd && input.charAt(5) !== '9') {
                    ddd = fone.substring(0, 2);
                    prefix = fone.substring(2, 6);
                    suffix = fone.substring(6, 10);
                } 
                if (settings.useDdd) {
                    ddd = (settings.useDddParenthesis ? '(' : '') + ddd;
                }
                if (settings.useDdd && prefix.length > 0) {
                    ddd += (settings.useDddParenthesis ? ')' : '') + settings.dddSeparator;
                }
                if (suffix.length > 0) {
                    prefix += settings.numberSeparator;
                }
                return ddd + prefix + suffix;
            };
            initialize();
        };
    }(jQuery));
    
    /*Altera o default do plugin*/
    $('.telefonecomddd').maskbrphone({  
        useDdd           : true,
        useDddParenthesis: true,
        dddSeparator     : ' ',
        numberSeparator  : '-'
    });
    
    /*Guarda o telefone sem formatação em um input escondido*/
    $(".telefonecomddd").change(function(){
        var a = $(".telefonecomddd").val();
        var telefone = a.replace(/[^0-9]+/g,'');
        $(".telefonesemddd").val(telefone);
    });
    
    /*Verificação das novas senhas*/
    $("#valida").keyup(verificaSenha);
    $("#valida2").keyup(verificaSenha);
});


