function injectScript($code) {
    var node = document.createElement('script');

    node.type = 'text/javascript';
    node.innerHTML = $code;

    document.body.appendChild(node);
}

injectScript('%1$s');