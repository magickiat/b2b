/* 
 * +-+ +-+ +-+ +-+ +-+ +-+ +-+ +-+ +-+ +-+ +-+
 * |4| |7| |R| |o| |n| |i| |n| |L| |a| |b| |s|
 * +-+ +-+ +-+ +-+ +-+ +-+ +-+ +-+ +-+ +-+ +-+
 */

var app = {
	order : {
		upload : function() {
			$('#upload-orders').submit();
		}
	}
};

$('#upload-form button[role="upload"]').on('click', function(event) {
	app.order.upload();
});
