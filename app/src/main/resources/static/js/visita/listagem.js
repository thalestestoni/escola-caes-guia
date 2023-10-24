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
                        <td class="col-md-2">${visita.email}</td>
                        <td class="col-md-2">${visita.endereco}</td>
                        <td class="col-md-2">${visita.bairro}</td>
                        <td class="col-md-2">${visita.cidade}</td>
                        <td class="col-md-1">${visita.cep}</td>
                        <td class="col-md-2">${visita.telefoneEscola}</td>
                        <td class="col-md-2">${visita.nomeResponsavel}</td>
                        <td class="col-md-2">${visita.telefoneResponsavel}</td>
                        <td class="col-md-2">${visita.numeroAlunos}</td>
                        <td class="col-md-2">${visita.serieEscolar}</td>
                        <td class="col-md-1">${visita.idadeAlunos}</td>
                        <td class="col-md-2">${visita.textoObjetivo}</td>
                        <td class="col-md-1">${visita.simNao ? "Sim" : "Não"}</td>
                        <td class="col-md-2">${visita.dataVisita}</td>
                        <td class="col-md-2">${visita.informacoesExtras}</td>
                        <td class="col-md-3 text-center">
                            <a class="icon-link icon-link-hover" href="${urlVisita}/visualizar" style="--bs-icon-link-transform: translate3d(0, -.125rem, 0);">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-eye" viewBox="0 0 16 16">
                                    <!-- Ícone de visualização -->
                                </svg>
                            </a>
                            <a class="icon-link icon-link-hover ms-3" href="${urlVisita}/editar" style="--bs-icon-link-transform: translate3d(0, -.125rem, 0);">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil-square" viewBox="0 0 16 16">
                                    <!-- Ícone de edição -->
                                </svg>
                            </a>
                            <a
                                class="icon-link icon-link-hover ms-3"
                                href="${urlVisita}/deletar"
                                style="--bs-icon-link-transform: translate3d(0, -.125rem, 0);"
                                data-bs-toggle="modal"
                                data-bs-target="#basicModal"
                                data-bs-modal-header="Excluir visita"
                                data-bs-modal-body="Tem certeza que deseja excluir esta visita?"
                                data-bs-modal-footer-text-cancel="Cancelar"
                                data-bs-modal-footer-text-confirm="Excluir"
                            >
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
                                    <!-- Ícone de exclusão -->
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
