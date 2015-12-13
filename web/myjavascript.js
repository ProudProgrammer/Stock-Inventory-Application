$(document).ready(function() {
    $("#top").hide();
    $("#top").show("slow");
    $("#leftside").hide();
    $("#leftside").show("slow");
    $("#menu>ul>li").each(function(i) {
        $(this).bind("click",function() {
            if(i == 0) {
                $.ajax({
                    type: "POST",
                    url:  "KeszletListazas",
                    success: function(msg) {
                        $("#rightside").html(msg);
                        $("#rightside").hide();
                        $("#rightside").show("slow");
                    }
                });
            }
            if(i == 1) {
                $.ajax({
                    type: "POST",
                    url:  "ujtermek.jsp",
                    success: function(msg) {
                        $("#rightside").html(msg);
                        $("#rightside").hide();
                        $("#rightside").show("slow");
                    }
                });
            }
            if(i == 2) {
                $.ajax({
                    type: "POST",
                    url:  "torles.jsp",
                    success: function(msg) {
                        $("#rightside").html(msg);
                        $("#rightside").hide();
                        $("#rightside").show("slow");
                    }
                });
            }
            if(i == 3) {
                $.ajax({
                    type: "POST",
                    url:  "modositas.jsp",
                    success: function(msg) {
                        $("#rightside").html(msg);
                        $("#rightside").hide();
                        $("#rightside").show("slow");
                    }
                });
            }
            if(i == 4) {
                $.ajax({
                    type: "POST",
                    url:  "beszerzes.jsp",
                    success: function(msg) {
                        $("#rightside").html(msg);
                        $("#rightside").hide();
                        $("#rightside").show("slow");
                    }
                });
            }
            if(i == 5) {
                $.ajax({
                    type: "POST",
                    url:  "eladas.jsp",
                    success: function(msg) {
                        $("#rightside").html(msg);
                        $("#rightside").hide();
                        $("#rightside").show("slow");
                    }
                });
            }
            if(i == 6) {
                $.ajax({
                    type: "POST",
                    url:  "JelentesListazas",
                    success: function(msg) {
                        $("#rightside").html(msg);
                        $("#rightside").hide();
                        $("#rightside").show("slow");
                    }
                });
            }
        });
    });
    $("#menu>ul>li:eq(0)").click();
});
