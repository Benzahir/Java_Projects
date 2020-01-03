/* JS for Pop-up on delete   */
/* delete event handler */
$('.CONFIRMDELETE').on('click',function(e) {
	var href = $(this).attr('href');
	var title = $(this).attr('data-dialog-title') ? $(this).attr('data-dialog-title') : 'Are you sure you want to permanently delete this record?';
	var msg = $(this).attr('data-dialog-msg') ? $(this).attr('data-dialog-msg') : 'You are about to permanently delete this record.';
	e.preventDefault();
	bootbox.dialog({
		title: title,
		message: msg,
		buttons:{
			danger:{
				label:"Delete",
				className:"btn-danger",	
				callback: function(){window.location.href = href;}
			},
			success:{
				label:"Cancel",
				className:"btn-primary"
			}		
		}		
	});
});

// prompt for is disabling breeder.
$('.inActive').on('click',function(e) {
	var href = $(this).attr('href');
	var title = $(this).attr('data-dialog-title') ? $(this).attr('data-dialog-title') : 'Are you sure you want to disable this breeder?';
	var msg = $(this).attr('data-dialog-msg') ? $(this).attr('data-dialog-msg') : 'You are about to disable this breeder.';
	e.preventDefault();
	bootbox.dialog({
		title: title,
		message: msg,
		buttons:{
			danger:{
				label:"Yes",
				className:"btn-default",	
				callback: function(){window.location.href = href;}
			},
			success:{
				label:"No",
				className:"btn-default"
			}		
		}		
	});
});

/* This is the code for Gallery   */

$(document).ready(function(){

    loadGallery(true, 'a.thumbnail');

    //This function disables buttons when needed
    function disableButtons(counter_max, counter_current){
        $('#show-previous-image, #show-next-image').show();
        if(counter_max == counter_current){
            $('#show-next-image').hide();
        } else if (counter_current == 1){
            $('#show-previous-image').hide();
        }
    }

    /**
     *
     * @param setIDs        Sets IDs when DOM is loaded. If using a PHP counter, set to false.
     * @param setClickAttr  Sets the attribute for the click handler.
     */

    function loadGallery(setIDs, setClickAttr){
        var current_image,
            selector,
            counter = 0;

        $('#show-next-image, #show-previous-image').click(function(){
            if($(this).attr('id') == 'show-previous-image'){
                current_image--;
            } else {
                current_image++;
            }

            selector = $('[data-image-id="' + current_image + '"]');
            updateGallery(selector);
        });

        function updateGallery(selector) {
            var $sel = selector;
            current_image = $sel.data('image-id');
            $('#image-gallery-caption').text($sel.data('caption'));
            $('#image-gallery-title').text($sel.data('title'));
            $('#image-gallery-image').attr('src', $sel.data('image'));
            disableButtons(counter, $sel.data('image-id'));
        }

        if(setIDs == true){
            $('[data-image-id]').each(function(){
                counter++;
                $(this).attr('data-image-id',counter);
            });
        }
        $(setClickAttr).on('click',function(){
            updateGallery($(this));
        });
    }
});

// Tooltip
/*$(function () {
	  $('[data-toggle="tooltip"]').tooltip()
})*/

/*image preview on select*/

$(function () {
    $("#files").change(function () {
        if (typeof (FileReader) != "undefined") {
            var dvPreview = $("#dvPreview");
            dvPreview.html("");
            var regex = /^([a-zA-Z0-9\s_\\.\-:])+(.jpg|.jpeg)$/;
            $($(this)[0].files).each(function () {
                var file = $(this);
                if (regex.test(file[0].name.toLowerCase())) {
                    var reader = new FileReader();
                    reader.onload = function (e) {
                        var img = $("<img />");
                        img.attr("style", "height:100px;width: 100px; margin:10px;");
                        img.attr("src", e.target.result);
                        dvPreview.append(img);
                    }
                    reader.readAsDataURL(file[0]);
                } else {
                    alert(file[0].name + " is not a valid image file.");
                    dvPreview.html("");
                    return false;
                }
            });
        } else {
            alert("This browser does not support HTML5 FileReader.");
        }
    });
});
