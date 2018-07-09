$(document).ready(function() {
	$('#donationsTable').dataTable();
	
	
	$('#password, #rpassword').on('keyup', function() {
		if ($('#password').val().trim() === $('#rpassword').val().trim()) {
			$('#password, #rpassword').css('border', '1px solid green');
			$('#message').html('Matching').css('color', 'green');
			$("#signUpBtn").prop("disabled", false);
		} else {
			$('#message').html('Not Matching').css('color', 'red');
			$('#password, #rpassword').css('border', '1px solid red');
			$("#signUpBtn").prop("disabled", true);
		}
	});
	
	$("#country").on("change",function(){
		$.ajax({
			url:"../institution/find/"+$(this).val(),
			method:"GET",
			success: function(resp){
				$("#institution option").remove();
				$("#institution").append($("<option />").val(null).text("--"));
				$(resp).each(function(){					
					$("#institution").append($("<option />").val(this[0]).text(this[1]));	
				})				
			}
		})
	});
	
	$("#creditCard").on("change",function(){
		validateCreditCard();
		$("#submitBtn").attr("disabled","true");
	});
	
	
	$("#saveCreditCard").click(function(){
		var token = $("meta[name='_csrf']").attr("content");
		var header = $("meta[name='_csrf_header']").attr("content");
		
		var creditCard = {
				"owner": $("#owner").val(),
				"securityCode": $("#securityCode").val(),
				"cardNumber": $("#cardNumber").val(),
				"creditCardType":$("#creditCardType").val(),
				"expirationMonth":$("#expirationMonth").val(),
				"expirationYear":$("#expirationYear").val()
			};
		$.ajax({
			url:"../creditcard/save",
			method:"POST",
			contentType : 'application/json; charset=utf-8',
			beforeSend: function(xhr) {
	            xhr.setRequestHeader(header, token);
	        },
			data:JSON.stringify(creditCard),
			complete: function(){				
				refreshCreditcards();
				 $('#addcreditcardModal').modal('toggle');
			}
		});		
	})
	
	
	$("#validateCreditCard").click(function(){
		var token = $("meta[name='_csrf']").attr("content");
		var header = $("meta[name='_csrf_header']").attr("content");
		
		var creditCard = {
				"owner": null,
				"securityCode": $("#securityCodeToValidate").val(),
				"cardNumber": $("#creditCard option:selected").text(),
				"creditCardType":null,
				"expirationMonth":null,
				"expirationYear":null
			};
		$.ajax({
			url:"../creditcard/validate",
			method:"POST",
			 contentType : 'application/json; charset=utf-8',
			dataType : 'json',
			beforeSend: function(xhr) {
	            xhr.setRequestHeader(header, token);
	        },
			data:JSON.stringify(creditCard),
			success: function(resp){
				if(resp){
					$('<div class="alert alert-success mt-2"><p>The card has been validated</p></div>').appendTo("#auxmessage");
					$("#submitBtn").removeAttr("disabled");
					
				}else{
					$('<div class="alert alert-danger mt-2"><p>Please verify the security code</p></div>').appendTo("#auxmessage");		
					$("#submitBtn").attr("disabled","true");
				}
				setTimeout(() => {
					$("#auxmessage").html("");
				}, 3500);
			}
		});		
	})
		

	$("#cardNumber").mask("999-999999-999999");
	$("#creditCardValidation").hide();		
	})
	




function refreshCreditcards(){	
	$.ajax({
		url:"../creditcard/find/",
		method:"GET",
		success: function(resp){
			$("#creditCard option").remove();
			$("#creditCard").append($("<option />").val(null).text("--"));
			$(resp).each(function(){					
				$("#creditCard").append($("<option />").val(this.idCard).text(this.cardNumber));	
			})				
		}
	});
}

function validateCreditCard(){
	$("#creditCardValidation").show();	
}