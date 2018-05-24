function injectStyle($code) {
    var node = document.createElement('style');

    node.type = 'text/css';
    node.innerHTML = $code;

    document.head.appendChild(node);
}

injectStyle('%1$s');