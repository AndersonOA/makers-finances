<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Bem-vindo(a) ao Makers Finances® - Entrar!</title>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<c:if test="${param.error ==  'invalid_user'}">
<div class="trigger_modal">
	<div class="trigger trigger_ajax trigger_info" style="display: block;">
		<b>OPPSSS:</b> E-mail ou Senha informado não é válido!<span class="ajax_close"></span>
	</div>
</div>
</c:if>

<div class="login">

<div class="code">
	<c:out value="${param.error}"></c:out>
</div>

	<div class="container login_container">
	    <div class="login_box">
	        <img class="login_logo" alt="[Makers Finances®]" title="Makers Finances®" src="../_cdn/vendors/img/helpeo_icon.png"/>
	        <form class="login_form" name="work_login" action="${contextPath}/plain/login.html" method="post" enctype="multipart/form-data">
	            <div class="callback_return m_botton"></div>
	            <input type="hidden" name="callback" value="Login">
	            <input type="hidden" name="callback_action" value="admin_login">
	
	            <label class="label">
	                <span class="legend">Seu E-mail:</span>
	                <input type="email" name="username" value="" placeholder="E-mail:" required />
	            </label>
	
	            <label class="label">
	                <span class="legend">Sua Senha:</span>
	                <input type="password" name="password" placeholder="Senha:" required />
	            </label>
	
	            <label class="label_check">
	                <input type="checkbox" name="user_remember" value="1"  > Lembrar!
	            </label>
	
	            <img class="form_load none" style="float: right; margin-top: 3px; margin-left: 10px;" alt="Enviando Requisição!" title="Enviando Requisição!" src="../_cdn/vendors/img/load.gif"/>
	            <button class="btn btn_red fl_right">Entrar!</button>
	            <div class="clear"></div>
	        </form>
	        <p class="login_link"><a href="./">Makers Finances!</a> &nbsp;&nbsp;&nbsp; <a href="esqueceu-senha.html">Perdeu sua senha?</a></p>
	    </div>
	</div>
	
	<div class="login_bg"></div>
</div><!-- /login -->