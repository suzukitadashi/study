        const asciidoctor = Asciidoctor(); 


$(function() {
    
    $('#editor').keyup(function() {
        var src = $(this).val();

        var asciidoctor = Asciidoctor();
        var html = asciidoctor.convert(src);
        console.log(html); 
        
        $('#result').html(html);
        
        $('pre code').each(function(i, block) {
            hljs.highlightBlock(block);
        });
        
    });
});