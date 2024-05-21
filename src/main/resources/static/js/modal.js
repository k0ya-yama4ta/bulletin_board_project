const modal = document.querySelector('.js-modal');
const modalButton = document.querySelector('.js-modal-button');	// モーダル表示用のボタンを取得
const modalClose = document.querySelector('.js-close-button');	//　モーダルのクローズボタンを取得

// モーダル表示ボタンをクリックしたときのイベントを登録
modalButton.addEventListener('click', ()=>{
	modal.classList.add('is-open');
});

// モーダルクローズボタン（×）をクリックしたときのイベントを登録
modalClose.addEventListener('click', ()=>{
	modal.classList.remove('is-open');
});

