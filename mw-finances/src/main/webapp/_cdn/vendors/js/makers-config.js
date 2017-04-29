//############## MODAL MESSAGE
function Trigger(Message) {
    $('.trigger_ajax').fadeOut('fast', function () {
        $(this).remove();
    });
    $('body').before("<div class='trigger_modal'>" + Message + "</div>");
    $('.trigger_ajax').fadeIn();
}

function TriggerClose() {
    $('.trigger_ajax').fadeOut('fast', function () {
        $(this).remove();
    });
}

//URI BASE REST
function sAction() {
	// Version API
	var VERSION = $('meta[name="makers_api_version"]').attr('content');
	
	return 'http://' + window.location.host + '/mw-finances/none/api/' + VERSION + '/';
}

//############## SERIALIZE FORM JSON
$.fn.serializeObject = function() {

	var self = this, json = {}, push_counters = {}, patterns = {
		"validate" : /^[a-zA-Z][a-zA-Z0-9_]*(?:\[(?:\d*|[a-zA-Z0-9_]+)\])*$/,
		"key" : /[a-zA-Z0-9_]+|(?=\[\])/g,
		"push" : /^$/,
		"fixed" : /^\d+$/,
		"named" : /^[a-zA-Z0-9_]+$/
	};

	this.build = function(base, key, value) {
		base[key] = value;
		return base;
	};

	this.push_counter = function(key) {
		if (push_counters[key] === undefined) {
			push_counters[key] = 0;
		}
		return push_counters[key]++;
	};

	$.each($(this).serializeArray(), function() {

		// skip invalid keys
		if (!patterns.validate.test(this.name)) {
			return;
		}

		var k, keys = this.name.match(patterns.key), merge = this.value, reverse_key = this.name;

		while ((k = keys.pop()) !== undefined) {

			// adjust reverse_key
			reverse_key = reverse_key.replace(new RegExp("\\["
					+ k + "\\]$"), '');

			// push
			if (k.match(patterns.push)) {
				merge = self.build([], self
						.push_counter(reverse_key), merge);
			}

			// fixed
			else if (k.match(patterns.fixed)) {
				merge = self.build([], k, merge);
			}

			// named
			else if (k.match(patterns.named)) {
				merge = self.build({}, k, merge);
			}
		}

		json = $.extend(true, json, merge);
	});

	return json;
};

// Function Reset Criada para resetar os formularios nas modais
jQuery.fn.reset = function() {
	this.each(function() {
		if ($(this).is('form')) {
			var button = jQuery(jQuery('<input type="reset" />'));
			button.hide();
			$(this).append(button);
			button.click().remove();
		} else if ($(this).parent('form').size()) {
			var button = jQuery(jQuery('<input type="reset" />'));
			button.hide();
			$(this).parent('form').append(button);
			button.click().remove();
		} else if ($(this).find('form').size()) {
			$(this).find('form').each(function() {
				var button = jQuery(jQuery('<input type="reset" />'));
				button.hide();
				$(this).append(button);
				button.click().remove();
			});
		}
	});

	return this;
};
