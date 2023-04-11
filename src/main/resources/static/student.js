let students = [];

async function fetchStudents() {
  const response = await fetch('/api/v1/student');
  const data = await response.json();
  students = data;
  renderStudents();
}

async function deleteStudent(id) {
  await fetch(`/api/v1/student/${id}`, { method: 'DELETE' });
  students = students.filter((student) => student.id !== id);
  renderStudents();
}

async function createStudent() {
  const name = document.getElementById('name').value;
  const age = parseInt(document.getElementById('age').value);
  const student = { name, age };
  const response = await fetch('/api/v1/student', {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(student),
  });
  const data = await response.json();
  students.push(data);
  renderStudents();
}

async function updateStudent(id) {
  const name = document.getElementById(`name-${id}`).value;
  const age = parseInt(document.getElementById(`age-${id}`).value);
  const student = { id, name, age };
  const response = await fetch(`/api/v1/student/${id}`, {
    method: 'PUT',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(student),
  });
  const data = await response.json();
  students = students.map((s) => (s.id === id ? data : s));
  renderStudents();
}

function renderStudents() {
  const tbody = document.querySelector('tbody');
  tbody.innerHTML = '';
  students.forEach((student) => {
    const tr = document.createElement('tr');
    const nameTD = document.createElement('td');
    const ageTD = document.createElement('td');
    const actionsTD = document.createElement('td');
    nameTD.innerHTML = `<input type="text" value="${student.name}" id="name-${student.id}">`;
    ageTD.innerHTML = `<input type="number" value="${student.age}" id="age-${student.id}" min="0">`;
    actionsTD.innerHTML = `
    <button onclick="updateStudent(${student.id})">
    Редактировать
    </button>
<button onclick="deleteStudent(${student.id})">
    Удалить
</button>
    `;
    tr.append(nameTD, ageTD, actionsTD);
    tbody.append(tr);
  });
}

fetchStudents();