# Poupá — App de Gestão Financeira (Android)

App de gestão financeira em WebView. Os dados guardam-se no telemóvel (localStorage), tema azul claro, conta individual ou familiar.

## Como gerar o APK (passo a passo)

1. Cria um repositório novo no GitHub (podes deixar privado).
2. Envia TODOS os ficheiros desta pasta para o repositório (mantém a estrutura).
3. No GitHub, vai ao separador **Actions**.
4. O workflow "Build APK do Poupá" corre sozinho ao enviares o código.
   - Se não correr, clica em "Build APK do Poupá" > botão **Run workflow**.
5. Espera ~3-5 minutos. Quando ficar verde ✓, abre a execução.
6. Em baixo, na secção **Artifacts**, descarrega **Poupa-APK**.
7. Dentro do zip está o ficheiro `.apk` — esse é o teu app!

## Distribuir aos clientes

1. Põe o `.apk` no Google Drive.
2. Depois de o cliente pagar no teu gateway, envia-lhe o link do Drive.
3. O cliente baixa, abre o ficheiro, e o Android pede para permitir
   "instalar de fontes desconhecidas" — é normal para apps fora da Play Store.
4. Instala e fica com o ícone "Poupá" no telemóvel.

## Estrutura
- `app/src/main/assets/index.html` — a tua app (o design todo está aqui).
- `app/src/main/java/.../MainActivity.kt` — carrega a app.
- `.github/workflows/build.yml` — compila o APK automaticamente.

## Usar no GitHub Codespaces (editar e testar na nuvem)

O Codespaces dá-te um computador na nuvem, dentro do navegador, já com tudo configurado.

### Abrir o Codespace
1. No teu repositório do GitHub, clica no botão verde **Code**.
2. Separador **Codespaces** > **Create codespace on main**.
3. Espera 1-2 minutos enquanto prepara o ambiente (Java + Android já incluídos).

### Ver a landing page / o app a correr
1. Abre o ficheiro `poupa-landing.html` (ou `app/src/main/assets/index.html`).
2. Clica com o botão direito > **Open with Live Server**.
3. Aparece um aviso de "porta aberta" — clica para abrir no navegador. Pronto, vês a página.

### Compilar o APK dentro do Codespace
No terminal do Codespace, escreve:
```
./gradlew assembleRelease
```
O APK fica em: `app/build/outputs/apk/release/app-release.apk`
Clica com o botão direito nesse ficheiro > **Download** para o guardares no teu computador.

> Nota: o Codespaces é para TU desenvolveres e testares. Os clientes continuam
> a receber o APK pelo link do Google Drive, como combinado.
