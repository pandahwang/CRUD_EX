function deleteArticleFromList(id) {
    fetch(`/delete/${id}`, {
        method: 'DELETE'
    })
    .then(response => {
            window.location.reload();
        })
    .catch(error => alert('Error:', error));
}

function deleteArticleFromView(id) {
    fetch(`/delete/${id}`, {
        method: 'DELETE'
    })
    .then(response => {
            window.location.href = '/list';
        })
    .catch(error => alert('Error:', error));
}