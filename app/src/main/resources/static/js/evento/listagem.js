document.addEventListener("DOMContentLoaded", () => {
    listagemEventos.functions.pagination.carregarListagemEventosPaginada();
});

var listagemEventos = {
    elements: {
        alert: () => {
            return document.querySelector("#listagem-eventos-container div[role=alert]");
        }
    },
    functions: {
        alert: {
            show: (message, type) => {
                let alert = listagemEventos.elements.alert();
                alert.innerHTML = `<div class="alert ${type}" role="alert">${message}</div>`;
                alert.hidden = false;
            },
            hide: () => {
                let alert = listagemEventos.elements.alert();
                alert.hidden = true;
            }
        },
        eventos: {
            construirLinhas: (eventos) => {
                let linhas = ``;
            
                eventos.forEach(evento => linhas += listagemEventos.functions.eventos.construirLinha(evento));
            
                return linhas;
            },
            construirLinha: (evento) => {
                const { dia, mes, ano } = listagemEventos.functions.eventos.formatarData(evento.data);

                return `
                    <div class="d-flex border border-secondary-subtle rounded-2 mb-3">
                        <div>
                            <div class="p-4">
                                <p class="mb-1 text-muted" style="font-size: 0.875rem;">${ano}</p>
                                <strong>
                                    <p class="mb-0" style="font-weight: 800;">${dia}/${mes}</p>
                                </strong>
                            </div>
                        </div>
                        <div class="p-3">
                            <h5>${evento.titulo}</h5>
                            <p>${evento.descricao}</p>
                        </div>
                    </div>
                `
            },
            formatarData(data) {
                let date = new Date(data);

                let dia = date.getDate().toString().padStart(2, '0');
                let mes = new Intl.DateTimeFormat('pt-BR', { month: 'long' }).format(date);
                mes = mes.charAt(0).toLocaleUpperCase() + mes.slice(1);
                let ano = date.getFullYear();

                return {
                    dia,
                    mes,
                    ano
                }
            }
        },
        pagination: {
            carregarListagemEventosPaginada: () => {
                const baseUrl = document.getElementById("base-url").value;
                const idCao = document.getElementById("id-cao").value;
            
                // Documentação: https://pagination.js.org
                $('#listagem-eventos-container')
                    .pagination({
                        dataSource: `${baseUrl}/rest/caes/${idCao}/eventos`,
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
                        formatAjaxError: (jqXHR, textStatus, errorThrown) => listagemEventos.functions.pagination.onError(jqXHR, textStatus, errorThrown),
                        callback: (data, pagination) => listagemEventos.functions.pagination.onSuccess(data, pagination)
                    });
            },
            onError: (jqXHR, textStatus, errorThrown) => {
                console.log("formatAjaxError", jqXHR, textStatus, errorThrown);

                //TODO: Testar o error!!
            
                let message = "Falha ao carregar os eventos";
                listagemEventos.functions.alert.show(message, alertType.danger);
            },
            onSuccess: (data, pagination) => {
                if (!data.length) {
                    let message = "Nenhum evento cadastrado";
                    listagemEventos.functions.alert.show(message, alertType.primary);
            
                    return;
                }
            
                listagemEventos.functions.alert.hide(); //TODO: Não da pra remover?
            
                var linhas = listagemEventos.functions.eventos.construirLinhas(data);
                $("#eventos-container").html(linhas);
            }
        }
    },
}

const alertType = {
    primary: "alert-primary",
    danger: "alert-danger"
}
