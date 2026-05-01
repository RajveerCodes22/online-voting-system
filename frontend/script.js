const BASE = "http://localhost:8080/api";

window.onload = function () {
    console.log("Page Loaded ✅");
    loadCandidates();
};

function loadCandidates() {
    fetch(BASE + "/candidates")
        .then(res => res.json())
        .then(data => {
            console.log("Candidates:", data);

            let dropdown = document.getElementById("candidate");
            dropdown.innerHTML = "";

            data.forEach(c => {
                let option = document.createElement("option");
                option.value = c.id;
                option.textContent = c.name;
                dropdown.appendChild(option);
            });
        })
        .catch(err => console.error("Error loading candidates:", err));
}

function register() {
    fetch(BASE + "/register", {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify({
            voterId: document.getElementById("id").value,
            name: document.getElementById("name").value
        })
    })
    .then(res => res.text())
    .then(msg => alert(msg))
    .catch(err => console.error(err));
}

function vote() {
    let vid = document.getElementById("vid").value;
    let cid = document.getElementById("candidate").value;

    fetch(`${BASE}/vote?voterId=${vid}&candidateId=${cid}`, {
        method: "POST"
    })
    .then(res => res.text())
    .then(msg => alert(msg))
    .catch(err => console.error(err));
}

function loadResults() {
    fetch(BASE + "/results")
        .then(res => res.json())
        .then(data => {
            let list = document.getElementById("resultList");
            list.innerHTML = "";

            data.forEach(c => {
                let li = document.createElement("li");
                li.textContent = c.name + " : " + c.votes;
                list.appendChild(li);
            });
        })
        .catch(err => console.error(err));
}