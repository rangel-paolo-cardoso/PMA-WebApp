const chartDataStr = decodeHTML(chartData);
const chartJSONArray = JSON.parse(chartDataStr);

// const arrayLength = chartJSONArray.length;
const numericData = [];
const labelData = [];

chartJSONArray.forEach((element) => {
  numericData.push(element.value);
  labelData.push(element.label);
});

new Chart(document.getElementById('myPieChart'), {
  type: 'pie',
  data: {
    labels: labelData,
    datasets: [
      {
        label: 'My First dataset',
        backgroundColor: ['#3e95cd', '#8e5ea2', '#3cba9f'],
        data: numericData,
        borderWidth: 1,
      },
    ],
  },
  options: {
    title: {
      display: true,
      text: 'Porject Statuses',
    },
    scales: {
      y: {
        beginAtZero: true,
      },
    },
  },
});

// "[
//   {"value": 1, "label": "COMPLETED"},
//   {"value": 2, "label": "INPROGRESS"},
//   {"value": 1, "label": "NOTSTARTED"}
// ]"
function decodeHTML(html) {
  const txt = document.createElement('textarea');
  txt.innerHTML = html;
  return txt.value;
}
