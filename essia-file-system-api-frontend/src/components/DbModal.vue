<template>
    <el-dialog title="Renomear" v-model="dialogFormVisible" :close-on-click-modal="false" :show-close="false">
        <el-form :model="form">
            <el-form-item label="Nome" :label-width="formLabelWidth">
                <el-input :disabled="false" v-model="form.nomePasta" auto-complete="off"></el-input>
            </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
            <el-button :plain="true" type="danger" v-on:click="canclemodal">Cancelar</el-button>
            <el-button :plain="true" @click="updateForm(form)">Salvar</el-button>
        </div>
    </el-dialog>
</template>


<script>
    export default {
        data(){
            return {
                formLabelWidth: '120px',
            }
        },
        props: ['dialogFormVisible', 'form'],

        methods: {
            updateForm: function (formName) {
                let itemId = formName.id;
                let nomePasta = formName.nomePasta;
                const idurl = 'http://127.0.0.1:8000/file-api/v1/pastas/';
                this.$axios.put(idurl, {
                    id: itemId,
                    nomePasta: nomePasta
                })
                    .then(function (response) {
                        console.log(response);
                        this.form = response.data;

                    })
                    .catch(function (error) {
                        console.log(error);
                    });
                location.reload();
            },
            canclemodal: function () {
                this.$emit('canclemodal');
            }
        }

    }

</script>