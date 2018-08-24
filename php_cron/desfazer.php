<?php
/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
if(!file_exists("/opt/SUNWappserver/domains/domain1/autodeploy/projovem.war.bak")){
    echo "<br />Voc&ecirc; n&atilde;o pode desfazer o envio do arquivo projovem.war porque n&atilde;o existe um arquivo de backup.";
}else{
    $criacao = filemtime("/opt/SUNWappserver/domains/domain1/autodeploy/projovem.war");
    $atual = mktime();
    print("Arquivo criado em: ".$criacao);
    print("<br />Data Atual: ".$atual."<br />");
    $intervalo = $atual-$criacao;
    print($intervalo);
    if($intervalo > 3600000){
        echo "<br />Você n&atilde;o pode mais desfazer o envio do arquivo projovem.war porque ele j&acute; foi atualizado h&acute; mais de 1 hora.";
    }else{
        echo "<br />Desfazendo o envio do arquivo projovem.war.";
        unlink("/opt/SUNWappserver/domains/domain1/autodeploy/projovem.war");
        rename("/opt/SUNWappserver/domains/domain1/autodeploy/projovem.war.bak", "/opt/SUNWappserver/domains/domain1/autodeploy/projovem.war");
    }
}

?>
