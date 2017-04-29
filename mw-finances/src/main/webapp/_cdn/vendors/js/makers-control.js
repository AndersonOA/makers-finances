/* 
 * Biblioteca de evendos jQuery 
 * Created on : 30/07/2016, 17:14:28
 * Author     : Anderson O. Aristides
 */
$(function() {

	// Ocultra Trigger clicada
	$('html').on('click', '.trigger_ajax, .trigger_modal', function() {
		$(this).fadeOut('slow', function() {
			$(this).remove();
		});
	});

	// Coloca todos os formulários em AJAX mode e inicia LOAD ao submeter!
	$('form').not('.ajax_off').submit(function() {
		var form = $(this);
		var callback = form.find('input[name="callback"]').val();
		var callback_action = form.find('input[name="callback_action"]').val();
		var typeForm = (callback_action === 'update' ? 'PUT' : 'POST');
		
		$.ajax({
			url : sAction() + callback,
			data : JSON.stringify(form.serializeObject()),
			type : typeForm,
			contentType : "application/json",
			beforeSend : function() {
				form.find('.form_load').fadeIn('slow');
				$('.trigger_ajax').fadeOut('fast');
			},
			success : function(response) {
				console.clear();
				// REMOVE LOAD
				form.find('.form_load').fadeOut('slow',function() {
					console.log(response.message);
					// EXIBE CALLBACKS
					if (response.message) {
						var CallBackPresent = form.find('.callback_return');
						if (CallBackPresent.length) {
							CallBackPresent.html(TriggerMessage(response.message, response.typeError));
							$('.trigger_ajax').fadeIn('slow');
							if (response.typeError === 'success') {
								form.reset();
							}
						} else {
							Trigger(response.message, response.typeError)
							if (response.typeError === 'success') {
								form.reset();
							}
						}
					}
					
					//REDIRECIONA
	                if (response.redirect) {
	                    window.setTimeout(function () {
	                        window.location.href = response.redirect;
	                    }, 500);
	                }
				});//form_load
			}
		});
		
		return false;
	});

}); // FIM
