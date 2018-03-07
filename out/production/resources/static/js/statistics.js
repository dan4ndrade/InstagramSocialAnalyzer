function allGraphs(r1, r2, r3, r4, r5, r6, unread_messages, unread_notifications) {
    barChart1();
    pieChart1(r1, r2, r3, r4, r5, r6);
    pieChart2(unread_messages, unread_notifications);
}

function barChart1() {

    var ctx = document.getElementById("barChart1").getContext('2d');
    var myChart = new Chart(ctx, {
        type: 'bar',
        data: {
            labels: ["Último dia", "Última semana", "Últimos 28 dias"],
            datasets: [{
                label: '# de acessos',
                data: [4, 12, 32],
                backgroundColor: [
                    'rgba(255, 99, 132, 0.2)',
                    'rgba(54, 162, 235, 0.2)',
                    'rgba(255, 206, 86, 0.2)'
                ],
                borderColor: [
                    'rgba(255,99,132,1)',
                    'rgba(54, 162, 235, 1)',
                    'rgba(255, 206, 86, 1)'
                ],
                borderWidth: 1
            }]
        },
        options: {
            scales: {
                yAxes: [{
                    ticks: {
                        beginAtZero:true
                    }
                }]
            }
        }
    });
}

function pieChart1(r1, r2, r3, r4, r5, r6) {
    var ctx = document.getElementById("pieChart1").getContext('2d');
    var myChart = new Chart(ctx, {
        type: 'pie',
        data: {
            labels: ["Gostei", "Amei", "Uau", "Haha", "Triste", "Grr"],
            datasets: [{
                label: '# of Votes',
                data: [r1, r2, r3, r4, r5, r6],
                backgroundColor: [
                    'rgba(54, 162, 235, 0.2)',
                    'rgba(255, 99, 132, 0.2)',
                    'rgba(255, 206, 86, 0.2)',
                    'rgba(75, 192, 192, 0.2)',
                    'rgba(153, 102, 255, 0.2)',
                    'rgba(255, 159, 64, 0.2)'
                ],
                borderColor: [
                    'rgba(54, 162, 235, 1)',
                    'rgba(255, 99, 132, 1)',
                    'rgba(255, 206, 86, 1)',
                    'rgba(75, 192, 192, 1)',
                    'rgba(153, 102, 255, 1)',
                    'rgba(255, 159, 64, 1)'
                ],
                borderWidth: 1
            }]
        },
        options: {
            scales: {
                xAxes: [{
                    gridLines: {
                        display:false,
                        drawBorder: false
                    },
                    ticks: {
                        beginAtZero:true,
                        display: false
                    }
                }],
                yAxes: [{
                    gridLines: {
                        display:false,
                        drawBorder: false
                    },
                    ticks: {
                        display: false
                    }
                }]
            }
        }
    });
}

function pieChart2(unread_messages, unread_notifications) {
    var ctx = document.getElementById("pieChart2").getContext('2d');
    var myChart = new Chart(ctx, {
        type: 'pie',
        data: {
            labels: ["Mensagens não lidas", "Notificações não lidas"],
            datasets: [{
                label: '# of Votes',
                data: [unread_messages, unread_notifications],
                backgroundColor: [
                    'rgba(153, 102, 255, 0.2)',
                    'rgba(255, 159, 64, 0.2)'
                ],
                borderColor: [
                    'rgba(153, 102, 255, 1)',
                    'rgba(255, 159, 64, 1)'
                ],
                borderWidth: 1
            }]
        },
        options: {
            scales: {
                xAxes: [{
                    gridLines: {
                        display:false,
                        drawBorder: false
                    },
                    ticks: {
                        beginAtZero:true,
                        display: false
                    }
                }],
                yAxes: [{
                    gridLines: {
                        display:false,
                        drawBorder: false
                    },
                    ticks: {
                        display: false
                    }
                }]
            }
        }
    });
}

