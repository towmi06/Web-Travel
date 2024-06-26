function loadSupportChangeCancel() {
    // Sử dụng XMLHttpRequest hoặc fetch để tải nội dung từ tệp HTML
    var xhr = new XMLHttpRequest();
    xhr.open('GET', 'customer-care/support-change-cancel.jsp', true);
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {
            document.getElementById('mainContent').innerHTML = xhr.responseText;
        }
    };
    xhr.send();
}

function sortTable2() {
    const table = document.getElementById("supportTable");
    const rows = Array.from(table.rows).slice(1);
    const columnIndex = document.getElementById("sort-options2").value;
    const isAscending = table.rows[0].cells[columnIndex].getAttribute('data-order') === 'asc';

    rows.sort((rowA, rowB) => {
        let cellA = rowA.cells[columnIndex].innerText.toLowerCase();
        let cellB = rowB.cells[columnIndex].innerText.toLowerCase();

        if (!isNaN(cellA) && !isNaN(cellB)) {
             cellA = parseFloat(cellA);
             cellB = parseFloat(cellB);
        }

        if (cellA < cellB) return isAscending ? -1 : 1;
        if (cellA > cellB) return isAscending ? 1 : -1;
        return 0;
    });

    table.tBodies[0].append(...rows);
    table.rows[0].cells[columnIndex].setAttribute('data-order', isAscending ? 'desc' : 'asc');
}


function searchTable2() {
    var input, filter, table, tr, td, i, j, txtValue;
    input = document.getElementById("searchInput");
    filter = input.value.toUpperCase();
    table = document.getElementById("supportTable");
    tr = table.getElementsByTagName("tr");
    
    for (i = 1; i < tr.length; i++) {
        var found = false;
        td = tr[i].getElementsByTagName("td");
        for (j = 0; j < td.length; j++) {
            if (td[j]) {
                txtValue = td[j].textContent || td[j].innerText;
                if (txtValue.toUpperCase().indexOf(filter) > -1) {
                    found = true;
                    break;
                }
            }       
        }
        if (found) {
            tr[i].style.display = "";
        } else {
            tr[i].style.display = "none";
        }
    }
}

document.addEventListener("DOMContentLoaded", function() {
    document.getElementById("searchInput2").addEventListener("keyup", searchTable2);
});