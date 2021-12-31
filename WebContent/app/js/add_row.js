$(document).ready(function () {
    var currentDate = new Date();
    $('.disableFuturedate').datepicker({
    format: 'dd/mm/yyyy',
    autoclose:true,
    endDate: "currentDate",
    maxDate: currentDate
    }).on('changeDate', function (ev) {
       $(this).datepicker('hide');
    });
    $('.disableFuturedate').keyup(function () {
       if (this.value.match(/[^0-9]/g)) {
          this.value = this.value.replace(/[^0-9^-]/g, '');
       }
    });
 });
