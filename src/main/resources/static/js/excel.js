var container = document.getElementById('example');

var data = [[]];

var hot = new Handsontable(container, {
    data : data,
    minSpareCols: 100,
    minSpareRows: 100,
    rowHeaders: true,
    colHeaders: true,
    stretchH: 'all'
});

hot.addHook('afterChange', function (changes) {
    send(changes[0][0], changes[0][1], changes[0][3]);
});

function insert(cell_i, cell_j, value) {
    data[cell_i][cell_j] = value;
    hot.updateSettings({height: $(window).height() - $(container).offset().top});
    hot.render();
}