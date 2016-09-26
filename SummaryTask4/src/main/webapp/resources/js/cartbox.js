/*CARTBOX */
jQuery(function($) {
	jQuery(".aa-cartbox").hover(function() {
		jQuery(this).find(".aa-cartbox-summary").fadeIn(500);
	}, function() {
		jQuery(this).find(".aa-cartbox-summary").fadeOut(500);
	});

});
