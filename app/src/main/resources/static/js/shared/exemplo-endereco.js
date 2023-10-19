document.addEventListener("DOMContentLoaded", () => {
  carregarCepFinder();
});

carregarCepFinder = () => {
  const elementos = document.querySelectorAll("input.cep-finder");

  elementos.forEach(elemento => {
    elemento.addEventListener("blur", (event) => buscarCep(event.target.value));
  });
}

buscarCep = (cep) => {
  if (!cep) {
    return;
  }

  $.ajax({
    url: `http://localhost:8080/endereco?cep=${cep}`,
    type: "GET",
    success: (response) => {
      document.getElementById("estado").value = response.estado;
      document.getElementById("cidade").value = response.cidade;
      document.getElementById("logradouro").value = `${response.logradouro} ${response.numero}`;
    },
    error: (error) => {
      //
    }
  });
}
