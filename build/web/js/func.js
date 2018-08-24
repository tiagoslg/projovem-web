function dataAtual(){
    mydate = new Date();
    myweekday= mydate.getDate();
    return myweekday;
}

function mascara_hora(hora){
    var myhora = '';
    myhora = myhora + hora.value;
    if (myhora.length == 2){

        myhora = myhora + ':';
        hora.value = myhora;
    }
}
function mascara_hora(hora,event){
    var KeyID = event.keyCode;
    var myhora = '';
    if(KeyID!=8){
        somente_numero(hora);
        myhora = myhora + hora.value;
        if (myhora.length == 2){

            myhora = myhora + ':';
            hora.value = myhora;
        }
    }
}
function mascara_data(data){
    var mydata = '';
    mydata = mydata + data.value;


    if (mydata.length == 2){
        mydata = mydata + '/';
        data.value = mydata;
    }
    if (mydata.length == 5){
        mydata = mydata + '/';
        data.value = mydata;
    }

}

function mascara_cep(cep,event){
    var KeyID = event.keyCode;
    var mycep = '';

    if(KeyID!=8){
        somente_numero(cep);
        mycep = mycep + cep.value;
        if (mycep.length == 5){

            mycep = mycep + '-';
            cep.value = mycep;
        }
    }
}

function mascara_telefone(data,event){
    var KeyID = event.keyCode;
    var mydata = '';

    if(KeyID!=8){
        somente_numero(data);

        mydata = mydata + data.value;

        if(mydata.length == 1)
            mydata = '(' + mydata;

        if(mydata.length == 3)
            mydata = mydata + ')';

        if(mydata.length == 8)
            mydata = mydata + '-';
        data.value = mydata;
    }

}

function mascara_cpf(data,event){
    var KeyID = event.keyCode;
    var mydata = '';

    if(KeyID!=8){
        somente_numero(data);

        mydata = mydata + data.value;

        if(mydata.length == 3)
            mydata =  mydata+'.';

        if(mydata.length == 7)
            mydata = mydata + '.';

        if(mydata.length == 11)
            mydata = mydata + '-';


        data.value = mydata;
    }

}

function mascara_data(data,event){
    var KeyID = event.keyCode;
    var mydata = '';

   
    if(KeyID!=8){
        somente_numero(data);

        mydata = mydata + data.value;

        letras = mydata.length;

        caracter = mydata.substr(letras-1, 1);
        if(caracter =="/"){
            data.value = mydata.substr(0,letras-1);
        }
        //  alert("Letras = "+letras+" caracter"+caracter);


    
        if (mydata.length == 2){
            mydata = mydata + '/';
            data.value = mydata;
        }
        if (mydata.length == 5){
            mydata = mydata + '/';
            data.value = mydata;
        }
    }

}

function somente_numero(campo){
    var digits="0123456789/:-()."
    var campo_temp
    for (var i=0;i<campo.value.length;i++){
        campo_temp=campo.value.substring(i,i+1)
        if (digits.indexOf(campo_temp)==-1){
            campo.value = campo.value.replace(campo_temp, "");
            break;
        }
    }
}

function Verifica_Hora(obj){
    var valor = '';


    valor = valor+ obj.value;
    if(valor!=''){
        hrs = (valor.substring(0,2));
        min = (valor.substring(3,5));

        var hrErrada = false;
        if ((hrs < 00 ) || (hrs > 23) || ( min < 00) ||( min > 59) || valor.length < 5){
            hrErrada = true;
        }

        if (hrErrada) {
            alert("Hora inválida. Por favor utilize notação 24 Horas.");
            obj.value='';
        }
    }
}

function CheckDate(pObj) {
    if(pObj.value!=''){
        var expReg = /^((0[1-9]|[12]\d)\/(0[1-9]|1[0-2])|30\/(0[13-9]|1[0-2])|31\/(0[13578]|1[02]))\/(19|20)?\d{2}$/;
        var aRet = true;
        if ((pObj) && (pObj.value.match(expReg)) && (pObj.value != '')) {
            var dia = pObj.value.substring(0,2);
            var mes = pObj.value.substring(3,5);
            var ano = pObj.value.substring(6,10);
            if ((mes == 4 || mes == 6 || mes == 9 || mes == 11 ) && dia > 30)
                aRet = false;
            else
            if ((ano % 4) != 0 && mes == 2 && dia > 28)
                aRet = false;
            else
            if ((ano%4) == 0 && mes == 2 && dia > 29)
                aRet = false;
        }  else
            aRet = false;

        if(!aRet){
            alert("Data inválida. Por Favor utilize o padrão dd/mm/aaaa");
            pObj.value='';
        }
        return aRet;
    }
}

function habilitarCampoComplementar(campo,campoParaHabilitar,opcaoParaHabilitar) {
    var resposta = campo.value;
    element1 = document.getElementById(campoParaHabilitar);
    var a = opcaoParaHabilitar;


    if(a.indexOf(resposta)>=0){
        element1.style.display = '';
    }else{
        element1.style.display = 'none';
    }

}

function habilitarTurma(campo,totalCampos, palavra){
    var resposta = campo.value;
    for(i=1;i<=totalCampos;i++){
        element1 = document.getElementById(palavra+i);
        element1.style.display = 'none';
    }
    if(resposta>0){
        for(i=1;i<=resposta;i++){
            element1 = document.getElementById(palavra+i);
            element1.style.display = '';
        }
    }
}

function desabilitarCampoComplementar(campo,campoParaHabilitar,opcaoParaHabilitar) {
    var resposta = campo.value;
    element1 = document.getElementById(campoParaHabilitar);
    var a = opcaoParaHabilitar;


    if(a.indexOf(resposta)>=0){
        element1.style.display = 'none';
    }else{
        element1.style.display = '';
    }

}
function bloquearCampo(campo,campoParaBloquear,opcaoParaBloquar) {
    var resposta = campo.checked;
    element1 = document.getElementById(campoParaBloquear);
    var a = opcaoParaBloquar;


    if(a.indexOf(resposta)>=0){
        element1.disabled = true;
        element1.value = "00/00/0000";
    }else{
        element1.disabled = false;
        element1.value = "";
    }

}


// Javascript Document
//adiciona mascara de cnpj
function MascaraCNPJ(campo){
    cnpj = campo.value;
    if(mascaraInteiro(cnpj)==false){
        event.returnValue = false;
    }
    return formataCampo(cnpj, '00.000.000/0000-00', event);
}

//adiciona mascara de cep
function MascaraCep(cep){
    if(mascaraInteiro(cep)==false){
        event.returnValue = false;
    }
    return formataCampo(cep, '00.000-000', event);
}

//adiciona mascara de data
function MascaraData(data){
    if(mascaraInteiro(data)==false){
        event.returnValue = false;
    }
    return formataCampo(data, '00/00/0000', event);
}

//adiciona mascara ao telefone
function MascaraTelefone(tel){
    if(mascaraInteiro(tel)==false){
        event.returnValue = false;
    }
    return formataCampo(tel, '(00) 0000-0000', event);
}

//adiciona mascara ao CPF
function MascaraCPF(cpf){
    if(mascaraInteiro(cpf)==false){
        event.returnValue = false;
    }
    return formataCampo(cpf, '000.000.000-00', event);
}

//valida telefone
function ValidaTelefone(tel){
    exp = /\(\d{2}\)\ \d{4}\-\d{4}/
    if(!exp.test(tel.value))
        alert('Numero de Telefone Invalido!');
}

//valida CEP
function ValidaCep(cep){
    exp = /\d{2}\.\d{3}\-\d{3}/
    if(!exp.test(cep.value))
        alert('Numero de Cep Invalido!');
}

//valida data
function ValidaData(data){
    exp = /\d{2}\/\d{2}\/\d{4}/
    if(!exp.test(data.value))
        alert('Data Invalida!');
}

//valida o CPF digitado
function ValidarCPF(Objcpf){
    var cpf = Objcpf.value;


    exp = /\.|\-/g
    cpf = cpf.toString().replace( exp, "" );

    if (cpf == "00000000000" || cpf == "11111111111" || cpf == "22222222222" || cpf == "33333333333" || cpf == "44444444444" || cpf == "55555555555" || cpf == "66666666666" || cpf == "77777777777" || cpf == "88888888888" || cpf == "99999999999"){
        alert('CPF Invalido!');
        Objcpf.value='';
    }


    var digitoDigitado = eval(cpf.charAt(9)+cpf.charAt(10));
    var soma1=0, soma2=0;
    var vlr =11;

    for(i=0;i<9;i++){
        soma1+=eval(cpf.charAt(i)*(vlr-1));
        soma2+=eval(cpf.charAt(i)*vlr);
        vlr--;
    }
    soma1 = (((soma1*10)%11)==10 ? 0:((soma1*10)%11));
    soma2=(((soma2+(2*soma1))*10)%11);

    var digitoGerado=(soma1*10)+soma2;
    if(digitoGerado!=digitoDigitado){
        alert('CPF Invalido!');
        Objcpf.value='';
    }
}

//valida numero inteiro com mascara
function mascaraInteiro(){
    if (event.keyCode < 48 || event.keyCode > 57){
        event.returnValue = false;
        return false;
    }
    return true;
}

//valida o CNPJ digitado
function ValidarCNPJ(ObjCnpj){
    var cnpj = ObjCnpj.value;
    var valida = new Array(6,5,4,3,2,9,8,7,6,5,4,3,2);
    var dig1= new Number;
    var dig2= new Number;

    exp = /\.|\-|\//g
    cnpj = cnpj.toString().replace( exp, "" );
    var digito = new Number(eval(cnpj.charAt(12)+cnpj.charAt(13)));

    for(i = 0; i<valida.length; i++){
        dig1 += (i>0? (cnpj.charAt(i-1)*valida[i]):0);
        dig2 += cnpj.charAt(i)*valida[i];
    }
    dig1 = (((dig1%11)<2)? 0:(11-(dig1%11)));
    dig2 = (((dig2%11)<2)? 0:(11-(dig2%11)));

    if(((dig1*10)+dig2) != digito)
        alert('CNPJ Invalido!');

}

//formata de forma generica os campos
function formataCampo(campo, Mascara, evento) {
    var boleanoMascara;

    var Digitato = evento.keyCode;
    exp = /\-|\.|\/|\(|\)| /g
    campoSoNumeros = campo.value.toString().replace( exp, "" );

    var posicaoCampo = 0;
    var NovoValorCampo="";
    var TamanhoMascara = campoSoNumeros.length;

    if (Digitato != 8) { // backspace
        for(i=0; i<= TamanhoMascara; i++) {
            boleanoMascara  = ((Mascara.charAt(i) == "-") || (Mascara.charAt(i) == ".")
                || (Mascara.charAt(i) == "/"))
            boleanoMascara  = boleanoMascara || ((Mascara.charAt(i) == "(")
                || (Mascara.charAt(i) == ")") || (Mascara.charAt(i) == " "))
            if (boleanoMascara) {
                NovoValorCampo += Mascara.charAt(i);
                TamanhoMascara++;
            }else {
                NovoValorCampo += campoSoNumeros.charAt(posicaoCampo);
                posicaoCampo++;
            }
        }
        campo.value = NovoValorCampo;
        return true;
    }else {
        return true;
    }
}

function formatarRotinas(questoes){

    for(i=0; i!=questoes.length; i ++){
        //alert(i +"<"+questoes.length)
        elementId = questoes[i][2];
        //alert("ID"+elementId);
        elementNome = 'form:'+questoes[i][0];
        element1 = document.getElementById(elementId);
        element1.style.display = 'none';
        var resposta = $(document.getElementsByName(elementNome).valueOf());
        //alert("Nome"+elementNome);
        for(j=0; j!=resposta.length; j++){
            if(resposta[j].checked == true){
                respValidas = questoes[i][1].split(";");
                for(k=0; k!=respValidas.length; k++){
                    if(resposta[j].value == respValidas[k]){
                        //alert(resposta[j].value +"=="+ respValidas[k])
                        element1.style.display = '';
                    }
                }
            }
        }
    }
}

function formatarRotinasTurmas(resposta){

    for(i=0; i!=resposta.length; i++){
        if(resposta[i].checked == true){
            nTurmas = resposta[i].value;
        }
    }
    for(i=1;i!=resposta.length;i++){
        elementId = "turma"+i;
        element1 = document.getElementById(elementId);
        if(nTurmas >= i){
            element1.style.display = '';
        }else{
            element1.style.display = 'none';
        }
    }
}
function formatarRotina004(){
    
    questoes = new Array();
    questoes[0] = new Array();
    questoes[0][0] = "q2"; questoes[0][1] = "sim"; questoes[0][2] = "q2Condicional";
    questoes[1] = new Array();
    questoes[1][0] = "q8"; questoes[1][1] = "sim"; questoes[1][2] = "q8Condicional";
    questoes[2] = new Array();
    questoes[2][0] = "q14";questoes[2][1] = "sim"; questoes[2][2] = "q14Condicional";
    questoes[3] = new Array();
    questoes[3][0] = "q61";questoes[3][1] = "sim"; questoes[3][2] = "q61Condicional";
    questoes[4] = new Array();
    questoes[4][0] = "q62";questoes[4][1] = "sim"; questoes[4][2] = "q62Condicional";
    questoes[5] = new Array();
    questoes[5][0] = "q63";questoes[5][1] = "sim"; questoes[5][2] = "q63Condicional";
    questoes[6] = new Array();
    questoes[6][0] = "q64";questoes[6][1] = "sim"; questoes[6][2] = "q64Condicional";
    questoes[7] = new Array();
    questoes[7][0] = "q65";questoes[7][1] = "sim"; questoes[7][2] = "q65Condicional";

    formatarRotinas(questoes);

    resposta = $(document.getElementsByName('form:q19').valueOf());
    formatarRotinasTurmas(resposta);
    
}


function formatarRotina005(){

    questoes = new Array();
    questoes[0] = new Array();
    questoes[0][0] = "q2"; questoes[0][1] = "sim"; questoes[0][2] = "q2Condicional";
    questoes[1] = new Array();
    questoes[1][0] = "q10";questoes[1][1] = "Sim"; questoes[1][2] = "q10Complemento";

    formatarRotinas(questoes);

    var resposta = $(document.getElementsByName('form:q5').valueOf());
    formatarRotinasTurmas(resposta);
}

function formatarRotina006(){

    questoes = new Array();
    questoes[0] = new Array();
    questoes[0][0] = "q54"; questoes[0][1] = "sim"; questoes[0][2] = "q54Complemento";

    formatarRotinas(questoes);
}

function formatarRotina007(){

    questoes = new Array();
    questoes[0] = new Array();
    questoes[0][0] = "exclusivoResponsavelAplicacaoQ3"; questoes[0][1] = "respondeu"; questoes[0][2] = "q2Condicional";
    questoes[1] = new Array();
    questoes[1][0] = "q9"; questoes[1][1] = "12mais;12menos;educadorNaoRespondeu"; questoes[1][2] = "q9Condicional";
    questoes[2] = new Array();
    questoes[2][0] = "q10"; questoes[2][1] = "outros"; questoes[2][2] = "q10Outros";
    questoes[3] = new Array();
    questoes[3][0] = "q16"; questoes[3][1] = "nao"; questoes[3][2] = "q16Outros";

    formatarRotinas(questoes);
}

function formatarRotinaCE001(){

    questoes = new Array();
    questoes[0] = new Array();
    questoes[0][0] = "q2"; questoes[0][1] = "sim"; questoes[0][2] = "q2Condicional";
    questoes[1] = new Array();
    questoes[1][0] = "q12"; questoes[1][1] = "sim"; questoes[1][2] = "q12Condicional";
    questoes[2] = new Array();
    questoes[2][0] = "q67"; questoes[2][1] = "sim"; questoes[2][2] = "q67Complemento";
    questoes[3] = new Array();
    questoes[3][0] = "q68"; questoes[3][1] = "sim"; questoes[3][2] = "q68Complemento";
    questoes[4] = new Array();
    questoes[4][0] = "q69"; questoes[4][1] = "sim"; questoes[4][2] = "q69Complemento";
    questoes[5] = new Array();
    questoes[5][0] = "q70"; questoes[5][1] = "sim"; questoes[5][2] = "q70Complemento";
    questoes[6] = new Array();
    questoes[6][0] = "q71"; questoes[6][1] = "sim"; questoes[6][2] = "q71Complemento";

    formatarRotinas(questoes);

    resposta = $(document.getElementsByName('form:q19').valueOf());
    formatarRotinasTurmas(resposta);
}

function formatarRotinaCE002(){

    questoes = new Array();
    questoes[0] = new Array();
    questoes[0][0] = "motivo"; questoes[0][1] = "respondeu"; questoes[0][2] = "q2Condicional";
    questoes[1] = new Array();
    questoes[1][0] = "q10"; questoes[1][1] = "sim;parcialmente"; questoes[1][2] = "q10Condicional";
    questoes[2] = new Array();
    questoes[2][0] = "q16"; questoes[2][1] = "sim12menos;sim12horas"; questoes[2][2] = "q16Condicional";
    questoes[3] = new Array();
    questoes[3][0] = "q20"; questoes[3][1] = "outro"; questoes[3][2] = "Q20Complemento";

    formatarRotinas(questoes);
}

function formatarRotinaCE003(){

    questoes = new Array();
    questoes[0] = new Array();
    questoes[0][0] = "q2"; questoes[0][1] = "sim"; questoes[0][2] = "q2Condicional";
    questoes[1] = new Array();
    questoes[1][0] = "q6"; questoes[1][1] = "sim"; questoes[1][2] = "q6Condicional";
    questoes[2] = new Array();
    questoes[2][0] = "q8"; questoes[2][1] = "sim"; questoes[2][2] = "q8Condicional";
    questoes[3] = new Array();
    questoes[3][0] = "q11"; questoes[3][1] = "sim"; questoes[3][2] = "q11Complemento";

    formatarRotinas(questoes);
}