document.addEventListener("DOMContentLoaded", () => {
  listagemVisitasEscola.functions.pagination.carregarListagemVisitasEscolaPaginada();
});

var listagemVisitasEscola = {
  elements: {
    alert: () => {
      return document.querySelector("#listagem-visitas-container div[role=alert]");
    },
    table: () => {
      return document.querySelector("#listagem-visitas-container table");
    }
  },
  functions: {
    alert: {
      show: (message, type) => {
        let alert = listagemVisitasEscola.elements.alert();
        alert.innerHTML = `<div class="alert ${type}" role="alert">${message}</div>`;
        alert.hidden = false;
      },
      hide: () => {
        let alert = listagemVisitasEscola.elements.alert();
        alert.hidden = true;
      }
    },
    table: {
      show: () => {
        let table = listagemVisitasEscola.elements.table();
        table.hidden = false;
      },
      hide: () => {
        let table = listagemVisitasEscola.elements.table();
        table.hidden = true;
      },
      construirLinhas: (visitas) => {
        let linhasTabela = ``;

        visitas.forEach(visita => linhasTabela += listagemVisitasEscola.functions.table.construirLinha(visita));

        return linhasTabela;
      },
      construirLinha: (visita) => {
        const baseUrl = document.getElementById("base-url").value;

        const urlVisita = `${baseUrl}/visitas/${visita.id}`;

        return `
                    <tr id="visita-item-list">
                        <td class="col-md-2">${visita.nomeEscola}</td>
                        <td class="col-md-2">${visita.endereco}</td>
                        <td class="col-md-2">${visita.bairro}</td>
                        <td class="col-md-2">${visita.cidade}</td>
                        <td class="col-md-2">${visita.nomeResponsavel}</td>
                        <td class="col-md-1">${visita.dataVisita}</td>
                        <td class="col-md-3 text-center">
                            <a class="icon-link icon-link-hover" href="${urlVisita}/visualizar" style="--bs-icon-link-transform: translate3d(0, -.125rem, 0);">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-eye" viewBox="0 0 16 16">
                                    <path d="M16 8s-3-5.5-8-5.5S0 8 0 8s3 5.5 8 5.5S16 8 16 8zM1.173 8a13.133 13.133 0 0 1 1.66-2.043C4.12 4.668 5.88 3.5 8 3.5c2.12 0 3.879 1.168 5.168 2.457A13.133 13.133 0 0 1 14.828 8c-.058.087-.122.183-.195.288-.335.48-.83 1.12-1.465 1.755C11.879 11.332 10.119 12.5 8 12.5c-2.12 0-3.879-1.168-5.168-2.457A13.134 13.134 0 0 1 1.172 8z"/>
                                    <path d="M8 5.5a2.5 2.5 0 1 0 0 5 2.5 2.5 0 0 0 0-5zM4.5 8a3.5 3.5 0 1 1 7 0 3.5 3.5 0 0 1-7 0z"/>
                                </svg>
                            </a>
                        </td>
                    </tr>
                `;
      }
    },
    pagination: {
      carregarListagemVisitasEscolaPaginada: () => {
        const baseUrl = document.getElementById("base-url").value;

        // Documentação: https://pagination.js.org
        $('#listagem-visitas-container tfoot')
          .pagination({
            dataSource: `${baseUrl}/api/visitas/pagina`,
            pageSize: 10,
            locator: "content",
            ajax: {
              pageNumberStartWithZero: true
            },
            alias: {
              pageNumber: "page",
              pageSize: "size"
            },
            totalNumberLocator: (response) => response.totalElements,
            formatAjaxError: (jqXHR, textStatus, errorThrown) => listagemVisitasEscola.functions.pagination.onError(jqXHR, textStatus, errorThrown),
            callback: (data, pagination) => listagemVisitasEscola.functions.pagination.onSuccess(data, pagination)
          });
      },
      onError: (jqXHR, textStatus, errorThrown) => {
        console.log("formatAjaxError", jqXHR, textStatus, errorThrown);

        listagemVisitasEscola.functions.table.hide();

        let message = "Falha ao carregar a listagem de visitas de escola";
        listagemVisitasEscola.functions.alert.show(message, alertType.danger);
      },
      onSuccess: (data, pagination) => {
        if (!data.length) {
          listagemVisitasEscola.functions.table.hide();

          let message = "Nenhuma visita de escola cadastrada";
          listagemVisitasEscola.functions.alert.show(message, alertType.primary);

          return;
        }

        listagemVisitasEscola.functions.alert.hide();

        var linhasTabela = listagemVisitasEscola.functions.table.construirLinhas(data);
        $("#listagem-visitas-container tbody").html(linhasTabela);

        listagemVisitasEscola.functions.table.show();
      }
    }
  },
};

const alertType = {
  primary: "alert-primary",
  danger: "alert-danger"
};
