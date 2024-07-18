document.addEventListener('DOMContentLoaded', function() {
/* Check if Thymeleaf condition is true */
//var errorCondition = /*[[${error}]]*/ false;
  if (errorCondition) {
      var modal = new bootstrap.Modal(document.getElementById('exampleModal'));
      modal.show();
   }
});
