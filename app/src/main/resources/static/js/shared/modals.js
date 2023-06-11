document.addEventListener("DOMContentLoaded", () => {
    modalFunctions.loadBasicModal();
});

const modalFunctions = {
    loadBasicModal: () => {
        const basicModal = document.getElementById('basicModal');

        if (basicModal) {
            basicModal.addEventListener('show.bs.modal', event => {
                // Button that triggered the modal
                const button = event.relatedTarget

                const header = button.getAttribute("data-bs-modal-header");
                const body = button.getAttribute("data-bs-modal-body");
                const cancelButtonText = button.getAttribute("data-bs-modal-footer-text-cancel");
                const confirmButtonText = button.getAttribute("data-bs-modal-footer-text-confirm");
                const urlAction = button.getAttribute("href");

                const modalTitle = basicModal.querySelector('.modal-title');
                const modalBody = basicModal.querySelector('.modal-body');
                const cancelButton = basicModal.querySelector('.modal-footer .btn-secondary');
                const confirmButton = basicModal.querySelector('.modal-footer .btn-primary');

                modalTitle.textContent = header;
                modalBody.textContent = body;
                cancelButton.textContent = cancelButtonText;
                confirmButton.textContent = confirmButtonText;

                confirmButton.addEventListener("click", () => {
                    window.location.href = urlAction;
                });
            });
        }
    }
}