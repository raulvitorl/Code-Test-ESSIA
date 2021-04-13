<template>
    <div>
        <el-table
                :data="tableData"
                >
            <el-table-column
                    prop="id"
                    label="id"
                    width="100%">
            </el-table-column>
            <el-table-column
                    prop="nomePasta"
                    label="Nome">
            </el-table-column>
            <el-table-column
                    prop="pai.nomePasta"
                    label="Pasta Acima">
            </el-table-column>
            <el-table-column
                    label="Operação"
                    width="120">
                <template scope="scope">
                    <el-button @click="EditarItem(scope.$index, tableData)" type="text" size="medium">Renomear</el-button>
                    
                </template>
            </el-table-column>
        </el-table>
        <el-pagination class="pagination" layout="prev, pager, next" :total="total" :page-size="pageSize"
                       v-on:current-change="changePage">
        </el-pagination>
        <db-modal :dialogFormVisible="dialogFormVisible" :form="form" v-on:canclemodal="dialogVisible"></db-modal>
    </div>

</template>

<script>
    import Bus from '../eventBus'
    import DbModal from './DbModal.vue'

    export default {
        data(){
            return {
                tableData: [],
                apiUrl: 'http://127.0.0.1:8000/file-api/v1/pastas',
                total: 0,
                pageSize: 2,
                currentPage: 0,
                pai: '',
                dialogFormVisible: false,
                form: '',
            }
        },
        components: {
            DbModal
        },
        mounted () {
            this.getPastas();
            Bus.$on('filterResultData', (data) => {
                this.tableData = data.registros;
                this.total = data.total_pages;
                this.pageSize = data.count;
                this.pai = data.pai;

            });
        },

        methods: {

            dialogVisible: function () {
                this.dialogFormVisible = false;
            },

            getPastas: function () {
                this.$axios.get(this.apiUrl, {
                    params: {
                        page: this.currentPage,
                        pageSize: this.pageSize
                    }
                }).then((response) => {
                    this.tableData = response.data.registros;
                    console.log(response)
                }).catch(function (response) {
                    console.log(response)
                });
            },
            changePage: function (currentPage) {
                this.currentPage = currentPage;
                this.getPastas()
            },
            EditarItem: function (index, rows) {
                this.dialogFormVisible = true;
                const itemId = rows[index].id;
                const idurl = 'http://127.0.0.1:8000/file-api/v1/pastas/?id=' + itemId;
                this.$axios.get(idurl).then((response) => {
                    this.form = response.data.registros[0];
                }).catch(function (response) {
                    console.log(response)
                });
            },
            formatter(row, column) {
                let data = this.$moment(row.create_datetime, this.$moment.ISO_8601);
                return data.format('YYYY-MM-DD')
            },
        }
    }
</script>

<style>
    .table {
        margin-top: 30px;
    }

    .pagination {
        margin-top: 10px;
        float: right;
    }

</style>