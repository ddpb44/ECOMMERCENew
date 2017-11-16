/**
 * 
 */

$(function () { 
     var dataURL = ''; 
     $('.table tr').each(function () { 
         var dataRow = ''; 
         $('td,th', this).each(function () { 
             dataRow += $(this).text() + ";"; 
         }); 
         dataURL += dataRow + '\n'; 
     }); 
     $('.btn').attr('href', 'data:text/csv;charset=utf-8;base64,' + btoa(dataURL)); 
 });