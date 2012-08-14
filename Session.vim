let SessionLoad = 1
if &cp | set nocp | endif
let s:cpo_save=&cpo
set cpo&vim
inoremap <silent> <S-Tab> =BackwardsSnippet()
inoremap <C-Tab> 	
snoremap <silent> 	 i<Right>=TriggerSnippet()
nmap  :JavaBrowser
map  :WMToggle
snoremap  b<BS>
nmap d :cs find d =expand("<cword>")	
nmap i :cs find i ^=expand("<cfile>")$
nmap f :cs find f =expand("<cfile>")	
nmap e :cs find e =expand("<cword>")	
nmap t :cs find t =expand("<cword>")	
nmap c :cs find c =expand("<cword>")	
nmap g :cs find g =expand("<cword>")	
nmap s :cs find s =expand("<cword>")	
map   /
vnoremap $/ `>a*/`<i/*
vnoremap $< `>a -->`<i<!-- 
vnoremap $w `>a"`<i"
vnoremap $q `>a'`<i'
vnoremap $$ `>a"`<i"
vnoremap $3 `>a}`<i{
vnoremap $2 `>a]`<i[
vnoremap $1 `>a)`<i(
snoremap % b<BS>%
snoremap ' b<BS>'
map ,tl :!adb shell am start -n  hongbosb.tbdemo/.MainActivity 
nmap <silent> ,cv <Plug>VCSVimDiff
nmap <silent> ,cu <Plug>VCSUpdate
nmap <silent> ,cU <Plug>VCSUnlock
nmap <silent> ,cs <Plug>VCSStatus
nmap <silent> ,cr <Plug>VCSReview
nmap <silent> ,cq <Plug>VCSRevert
nmap <silent> ,cn <Plug>VCSAnnotate
nmap <silent> ,cN <Plug>VCSSplitAnnotate
nmap <silent> ,cl <Plug>VCSLog
nmap <silent> ,cL <Plug>VCSLock
nmap <silent> ,ci <Plug>VCSInfo
nmap <silent> ,cg <Plug>VCSGotoOriginal
nmap <silent> ,cG <Plug>VCSClearAndGotoOriginal
nmap <silent> ,cD <Plug>VCSDelete
nmap <silent> ,cc <Plug>VCSCommit
nmap <silent> ,ca <Plug>VCSAdd
nmap ,caL <Plug>CalendarH
nmap ,cal <Plug>CalendarV
nmap ,scp <Plug>SQLUCreateProcedure
nmap ,scdt <Plug>SQLUGetColumnDataType
nmap ,scd <Plug>SQLUGetColumnDef
nmap ,scl <Plug>SQLUCreateColumnList
vmap ,sf <Plug>SQLUFormatter
nmap ,sf <Plug>SQLUFormatter
vmap ,sfs <Plug>SQLUFormatter
nmap ,sfs <Plug>SQLUFormatter
vmap ,sfr <Plug>SQLUFormatStmts
nmap ,sfr <Plug>SQLUFormatStmts
nnoremap <silent> ,b :CommandTBuffer
nnoremap <silent> ,t :CommandT
vnoremap <silent> ,,w :call EasyMotion#WB(1, 0)
onoremap <silent> ,,w :call EasyMotion#WB(0, 0)
nnoremap <silent> ,,w :call EasyMotion#WB(0, 0)
vnoremap <silent> ,,t :call EasyMotion#T(1, 0)
onoremap <silent> ,,t :call EasyMotion#T(0, 0)
nnoremap <silent> ,,t :call EasyMotion#T(0, 0)
vnoremap <silent> ,,n :call EasyMotion#Search(1, 0)
onoremap <silent> ,,n :call EasyMotion#Search(0, 0)
nnoremap <silent> ,,n :call EasyMotion#Search(0, 0)
vnoremap <silent> ,,k :call EasyMotion#JK(1, 1)
onoremap <silent> ,,k :call EasyMotion#JK(0, 1)
nnoremap <silent> ,,k :call EasyMotion#JK(0, 1)
vnoremap <silent> ,,j :call EasyMotion#JK(1, 0)
onoremap <silent> ,,j :call EasyMotion#JK(0, 0)
nnoremap <silent> ,,j :call EasyMotion#JK(0, 0)
vnoremap <silent> ,,gE :call EasyMotion#EW(1, 1)
onoremap <silent> ,,gE :call EasyMotion#EW(0, 1)
nnoremap <silent> ,,gE :call EasyMotion#EW(0, 1)
vnoremap <silent> ,,f :call EasyMotion#F(1, 0)
onoremap <silent> ,,f :call EasyMotion#F(0, 0)
nnoremap <silent> ,,f :call EasyMotion#F(0, 0)
vnoremap <silent> ,,e :call EasyMotion#E(1, 0)
onoremap <silent> ,,e :call EasyMotion#E(0, 0)
nnoremap <silent> ,,e :call EasyMotion#E(0, 0)
vnoremap <silent> ,,b :call EasyMotion#WB(1, 1)
onoremap <silent> ,,b :call EasyMotion#WB(0, 1)
nnoremap <silent> ,,b :call EasyMotion#WB(0, 1)
vnoremap <silent> ,,W :call EasyMotion#WBW(1, 0)
onoremap <silent> ,,W :call EasyMotion#WBW(0, 0)
nnoremap <silent> ,,W :call EasyMotion#WBW(0, 0)
vnoremap <silent> ,,T :call EasyMotion#T(1, 1)
onoremap <silent> ,,T :call EasyMotion#T(0, 1)
nnoremap <silent> ,,T :call EasyMotion#T(0, 1)
vnoremap <silent> ,,N :call EasyMotion#Search(1, 1)
onoremap <silent> ,,N :call EasyMotion#Search(0, 1)
nnoremap <silent> ,,N :call EasyMotion#Search(0, 1)
vnoremap <silent> ,,ge :call EasyMotion#E(1, 1)
onoremap <silent> ,,ge :call EasyMotion#E(0, 1)
nnoremap <silent> ,,ge :call EasyMotion#E(0, 1)
vnoremap <silent> ,,F :call EasyMotion#F(1, 1)
onoremap <silent> ,,F :call EasyMotion#F(0, 1)
nnoremap <silent> ,,F :call EasyMotion#F(0, 1)
vnoremap <silent> ,,E :call EasyMotion#EW(1, 0)
onoremap <silent> ,,E :call EasyMotion#EW(0, 0)
nnoremap <silent> ,,E :call EasyMotion#EW(0, 0)
vnoremap <silent> ,,B :call EasyMotion#WBW(1, 1)
onoremap <silent> ,,B :call EasyMotion#WBW(0, 1)
nnoremap <silent> ,,B :call EasyMotion#WBW(0, 1)
vnoremap ,p :call EchoSelectionLines()
noremap ,m :make
map ,wp :call SwitchToProject("PROVIDER")
map ,wr :call SwitchToProject("RES")
map ,wf :call SwitchToProject("FRA")
map ,wh :call SwitchToProject("CALL_HISTORY")
map ,wc :call SwitchToProject("CONTACTS")
map <silent> ,bt :!ctags -R --exclude=\.* 
noremap ,vcs :e res/values-zh-rCN/strings.xml
noremap ,ves :e res/values/strings.xml
noremap ,di :call DebugInnerContacts()
noremap ,dd :call StartDebug()
noremap ,tc :!adb_connect
noremap ,tr :!adb_connect&&adb shell stop && adb shell start
nnoremap ,0 :10b
nnoremap ,9 :9b
nnoremap ,8 :8b
nnoremap ,7 :7b
nnoremap ,6 :6b
nnoremap ,5 :5b
nnoremap ,4 :4b
nnoremap ,3 :3b
map ,z <Plug>ZoomWin
noremap <silent> ,bc :!find -name *.java > cscope.files && cscope -b -q
noremap ,ts :!target_sync
map ,s :so ~/.vimrc
map ,v :e ~/.vimrc
map <silent> ,vp :!xdg-open %
map ,ac :!adb_connect&&adb logcat -c
map ,al :!adb_connect&&adb logcat
map ,vxs :sp ~/.vim/snippets/xml.snippets
map ,vjs :sp ~/.vim/snippets/java.snippets
nmap ,rr :call ReloadSnippets(snippets_dir, &filetype)
map ,y :YRShow
map ,s? z=
map ,sa zg
map ,sp [
map ,sn ]
map ,q :e ~/buffer
noremap ,cd :call CdToProjectRoot()
nmap ,fu :se ff=unix
nmap ,fd :se ff=dos
map ,$ :syntax sync fromstart
vmap ,4 :set ft=javascript
omap ,4 :set ft=javascript
vmap ,3 :set syntax=python
omap ,3 :set syntax=python
map ,2 :set syntax=xhtml
map ,1 :set syntax=cheetah
nmap ,w :w!
nmap ,x :xa!
map 0 ^
snoremap U b<BS>U
vmap [% [%m'gv``
snoremap \ b<BS>\
vmap ]% ]%m'gv``
snoremap ^ b<BS>^
snoremap ` b<BS>`
vmap a% [%v]%
nmap gx <Plug>NetrwBrowseX
snoremap <Left> bi
snoremap <Right> a
snoremap <BS> b<BS>
snoremap <silent> <S-Tab> i<Right>=BackwardsSnippet()
nnoremap <silent> <Plug>NetrwBrowseX :call netrw#NetrwBrowseX(expand("<cWORD>"),0)
nnoremap <silent> <Plug>VCSVimDiff :VCSVimDiff
nnoremap <silent> <Plug>VCSUpdate :VCSUpdate
nnoremap <silent> <Plug>VCSUnlock :VCSUnlock
nnoremap <silent> <Plug>VCSStatus :VCSStatus
nnoremap <silent> <Plug>VCSSplitAnnotate :VCSAnnotate!
nnoremap <silent> <Plug>VCSReview :VCSReview
nnoremap <silent> <Plug>VCSRevert :VCSRevert
nnoremap <silent> <Plug>VCSLog :VCSLog
nnoremap <silent> <Plug>VCSLock :VCSLock
nnoremap <silent> <Plug>VCSInfo :VCSInfo
nnoremap <silent> <Plug>VCSClearAndGotoOriginal :VCSGotoOriginal!
nnoremap <silent> <Plug>VCSGotoOriginal :VCSGotoOriginal
nnoremap <silent> <Plug>VCSDiff :VCSDiff
nnoremap <silent> <Plug>VCSDelete :VCSDelete
nnoremap <silent> <Plug>VCSCommit :VCSCommit
nnoremap <silent> <Plug>VCSAnnotate :VCSAnnotate
nnoremap <silent> <Plug>VCSAdd :VCSAdd
nnoremap <silent> <F11> :call conque_term#exec_file()
nnoremap <silent> <Plug>CalendarH :cal Calendar(1)
nnoremap <silent> <Plug>CalendarV :cal Calendar(0)
noremap <F2> :NERDTreeToggle
nmap <Nul><Nul>d :vert scs find d =expand("<cword>")
nmap <Nul><Nul>i :vert scs find i ^=expand("<cfile>")$	
nmap <Nul><Nul>f :vert scs find f =expand("<cfile>")	
nmap <Nul><Nul>e :vert scs find e =expand("<cword>")
nmap <Nul><Nul>t :vert scs find t =expand("<cword>")
nmap <Nul><Nul>c :vert scs find c =expand("<cword>")
nmap <Nul><Nul>g :vert scs find g =expand("<cword>")
nmap <Nul><Nul>s :vert scs find s =expand("<cword>")
nmap <Nul>d :scs find d =expand("<cword>")	
nmap <Nul>i :scs find i ^=expand("<cfile>")$	
nmap <Nul>f :scs find f =expand("<cfile>")	
nmap <Nul>e :scs find e =expand("<cword>")	
nmap <Nul>t :scs find t =expand("<cword>")	
nmap <Nul>c :scs find c =expand("<cword>")	
nmap <Nul>g :scs find g =expand("<cword>")	
nmap <Nul>s :scs find s =expand("<cword>")	
map <F3> :Tlist
map <F9> ggVGg?
cnoremap  <Home>
cnoremap  <End>
inoremap <silent> 	 =TriggerSnippet()
cnoremap  
imap  <Plug>SuperTabForward
imap  <Plug>SuperTabBackward
inoremap <silent> 	 =ShowAvailableSnips()
cnoremap $td tabnew ~/Desktop/
cnoremap $th tabnew ~/
vmap ë :m'<-2`>my`<mzgv`yo`z
vmap ê :m'>+`<my`>mzgv`yo`z
nmap ë mz:m-2`z
nmap ê mz:m+`z
cabbr <expr> %$ expand('%:t:r')
cabbr <expr> %% expand('%:h')
iabbr xdate =strftime("%d/%m/%y %H:%M:%S")
let &cpo=s:cpo_save
unlet s:cpo_save
set ambiwidth=double
set autoindent
set autoread
set autowrite
set background=dark
set backspace=2
set cindent
set cmdheight=2
set cscopeverbose
set errorformat=%A\ %#[javac]\ %f:%l:\ %m,%A\ %#[aapt]\ %f:%l:\ %m,%-Z\ %#[javac]\ %p^,%-C%.%#
set expandtab
set fileencodings=ucs-bom,utf-8,cp936,big5,euc-jp,euc-kr,latin1
set hidden
set ignorecase
set incsearch
set keywordprg=androiddoc.py
set laststatus=2
set lazyredraw
set makeprg=ant\ clean\ debug\ install
set matchtime=8
set modelines=0
set mouse=a
set path=.,/usr/include,,,res/layout,res/layout-finger,res/values,res/drawable,res/drawable-mdpi
set ruler
set runtimepath=~/.vim/bundle/vundle,~/.vim/bundle/vim-fugitive,~/.vim/bundle/vim-easymotion,~/.vim/bundle/sparkup/vim/,~/.vim/bundle/vim-rails,~/.vim/bundle/L9,~/.vim/bundle/FuzzyFinder,~/.vim/bundle/command-t,~/.vim/bundle/vim-powerline,~/.vim,/usr/share/vim/vimfiles,/usr/share/vim/vim73,/usr/share/vim/vimfiles/after,~/.vim/after,~/.vim/bundle/vundle/,~/.vim/bundle/vundle/after,~/.vim/bundle/vim-fugitive/after,~/.vim/bundle/vim-easymotion/after,~/.vim/bundle/sparkup/vim//after,~/.vim/bundle/vim-rails/after,~/.vim/bundle/L9/after,~/.vim/bundle/FuzzyFinder/after,~/.vim/bundle/command-t/after,~/.vim/bundle/vim-powerline/after
set scrolloff=7
set sessionoptions=options
set shell=bash\ -l
set shiftwidth=4
set showmatch
set smartindent
set smarttab
set softtabstop=4
set statusline=%02n:%<%f\ %h%m%r%=%-14.(%l,%c%V%)\ %P
set suffixes=.bak,~,.o,.h,.info,.swp,.obj,.class
set suffixesadd=.java,.xml,.9.png,.png,.xml,.png,.9.png
set noswapfile
set tabline=%!TabCaptionLineFunction()
set wildmenu
set window=0
set nowritebackup
let s:so_save = &so | let s:siso_save = &siso | set so=0 siso=0
let v:this_session=expand("<sfile>:p")
silent only
if expand('%') == '' && !&modified && line('$') <= 1 && getline(1) == ''
  let s:wipebuf = bufnr('%')
endif
set shortmess=aoO
badd +0 ~/workspace_tb/rss_client/src/hongbosb/tbdemo/MainActivity.java
silent! argdel *
edit ~/workspace_tb/rss_client/src/hongbosb/tbdemo/MainActivity.java
set splitbelow splitright
set nosplitbelow
set nosplitright
wincmd t
set winheight=1 winwidth=1
argglobal
setlocal autoindent
setlocal nobinary
setlocal bufhidden=
setlocal buflisted
setlocal buftype=
setlocal cindent
setlocal cinkeys=0{,0},0),:,0#,!^F,o,O,e
setlocal cinoptions=j1
setlocal cinwords=if,else,while,do,for,switch
setlocal colorcolumn=
setlocal comments=sO:*\ -,mO:*\ \ ,exO:*/,s1:/*,mb:*,ex:*/,://,b:#,:%,:XCOMM,n:>,fb:-
setlocal commentstring=//%s
setlocal complete=.,w,b,u,t,i
setlocal completefunc=
setlocal nocopyindent
setlocal cryptmethod=
setlocal nocursorbind
setlocal nocursorcolumn
setlocal nocursorline
setlocal define=
setlocal dictionary=
setlocal nodiff
setlocal equalprg=
setlocal errorformat=
setlocal expandtab
if &filetype != 'java'
setlocal filetype=java
endif
setlocal foldcolumn=0
setlocal foldenable
setlocal foldexpr=0
setlocal foldignore=#
setlocal foldlevel=0
setlocal foldmarker={{{,}}}
setlocal foldmethod=manual
setlocal foldminlines=1
setlocal foldnestmax=20
setlocal foldtext=foldtext()
setlocal formatexpr=
setlocal formatoptions=croql
setlocal formatlistpat=^\\s*\\d\\+[\\]:.)}\\t\ ]\\s*
setlocal grepprg=
setlocal iminsert=0
setlocal imsearch=0
setlocal include=
setlocal includeexpr=substitute(v:fname,'\\.','/','g')
setlocal indentexpr=GetJavaIndent_improved()
setlocal indentkeys=0{,0},:,0#,!^F,o,O,e,0=extends,0=implements
setlocal noinfercase
setlocal iskeyword=@,48-57,_,192-255
setlocal keywordprg=
set linebreak
setlocal linebreak
setlocal nolisp
setlocal nolist
setlocal makeprg=
setlocal matchpairs=(:),{:},[:]
setlocal modeline
setlocal modifiable
setlocal nrformats=octal,hex
set number
setlocal number
setlocal numberwidth=4
setlocal omnifunc=
setlocal path=
setlocal nopreserveindent
setlocal nopreviewwindow
setlocal quoteescape=\\
setlocal noreadonly
setlocal norelativenumber
setlocal noscrollbind
setlocal shiftwidth=4
setlocal noshortname
setlocal smartindent
setlocal softtabstop=4
setlocal nospell
setlocal spellcapcheck=
setlocal spellfile=
setlocal spelllang=en
setlocal statusline=%!Pl#Statusline(0,1)
setlocal suffixesadd=.java
setlocal noswapfile
setlocal synmaxcol=3000
if &syntax != 'java'
setlocal syntax=java
endif
setlocal tabstop=8
setlocal tags=~/workspace_tb/rss_client/.git/java.tags,~/workspace_tb/rss_client/.git/tags,./tags,tags
setlocal textwidth=0
setlocal thesaurus=
setlocal noundofile
setlocal nowinfixheight
setlocal nowinfixwidth
setlocal wrap
setlocal wrapmargin=0
let s:l = 91 - ((25 * winheight(0) + 24) / 49)
if s:l < 1 | let s:l = 1 | endif
exe s:l
normal! zt
91
normal! 08l
if exists('s:wipebuf')
  silent exe 'bwipe ' . s:wipebuf
endif
unlet! s:wipebuf
set winheight=1 winwidth=20 shortmess=filnxtToO
let s:sx = expand("<sfile>:p:r")."x.vim"
if file_readable(s:sx)
  exe "source " . fnameescape(s:sx)
endif
let &so = s:so_save | let &siso = s:siso_save
doautoall SessionLoadPost
unlet SessionLoad
" vim: set ft=vim :
