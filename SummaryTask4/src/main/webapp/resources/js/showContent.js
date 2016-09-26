var current = 'page1';
function showContent(id) {
    document.getElementById(current).style.display = 'none';
    document.getElementById(id).style.display = 'block';
    current = id;
}