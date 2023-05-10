new Chart(document.getElementById("myPieChart"), {
  type: 'pie',
  data: {
    labels: ['January', 'February', 'March'],
    datasets: [
      {
        label: 'My First dataset',
        backgroundColor: ['#3e95cd', '#8e5ea2', '#3cba9f'],
        data: [12, 19, 15],
        borderWidth: 1,
      },
    ],
  },
  options: {
    scales: {
      y: {
        beginAtZero: true,
      },
    },
  },
});
